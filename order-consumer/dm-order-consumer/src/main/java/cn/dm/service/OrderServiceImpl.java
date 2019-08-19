package cn.dm.service;

import cn.dm.client.*;
import cn.dm.common.*;
import cn.dm.exception.OrderErrorCode;
import cn.dm.pojo.*;
import cn.dm.vo.CreateOrderVo;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestDmItemClient restDmItemClient;
    @Autowired
    private RestDmSchedulerSeatClient restDmSchedulerSeatClient;
    @Autowired
    private RestDmSchedulerSeatPriceClient restDmSchedulerSeatPriceClient;
    @Autowired
    private RestDmOrderClient restDmOrderClient;
    @Autowired
    private RestDmLinkUserClient restDmLinkUserClient;
    @Autowired
    private RestDmOrderLinkUserClient restDmOrderLinkUserClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Dto createOrder(CreateOrderVo orderVo) throws Exception {
        //先查询对应的商品信息，如果没有，则直接返回错误信息
        DmItem dmItem = restDmItemClient.getDmItemById(orderVo.getItemId());
        if (EmptyUtils.isEmpty(dmItem)) {
            throw new BaseException(OrderErrorCode.ORDER_NO_DATA);
        }
        //生成订单唯一编号
        String orderNo = IdWorker.getId();
        //拆分座位集合信息
        String[] seatArray = orderVo.getSeatPositions().split(",");
        //先当前座位对用的剧场锁定，避免同时操作
        while (!redisUtils.lock(String.valueOf(orderVo.getSchedulerId()))){
            //当前正被别人使用
            TimeUnit.SECONDS.sleep(3);
        }
        boolean isLock = false;
        //查看当前座位是否已经被占用，如果已经被占用则直接返回下单失败
        for (int i = 0; i < seatArray.length; i++) {
            if (EmptyUtils.isNotEmpty(redisUtils.get(orderVo.getSchedulerId()+":"+seatArray[i]))) {
                //当前座位已经存在redis中，代表已经被占用
                isLock = true;
                break;
            }
        }
        if (isLock) {
            //座位被占用，返回下单失败
            redisUtils.unlock(String.valueOf(orderVo.getSchedulerId()));
            throw  new BaseException(OrderErrorCode.ORDER_SEAT_LOCKED);
        }
        //总价格
        double totalAmount = 0;
        //座位价格集合
        Double[] doublePrices = new Double[seatArray.length];
        DmSchedulerSeat dmSchedulerSeat = null;
        for (int i = 0; i < seatArray.length; i++) {
            String[] seats = seatArray[i].split("_");
            //查询每个座位的信息
            dmSchedulerSeat = restDmSchedulerSeatClient.getDmSchedulerSeatByOrder(
                    orderVo.getSchedulerId(),
                    Integer.parseInt(seats[0]),
                    Integer.parseInt(seats[1]));
            //更新座位的状态为锁定状态
            dmSchedulerSeat.setStatus(Constants.SchedulerSeatStatus.SchedulerSeat_TOPAY);
            //更新下单用户
            dmSchedulerSeat.setUserId(orderVo.getUserId());
            dmSchedulerSeat.setUpdatedTime(new Date());
            //更新订单编号
            dmSchedulerSeat.setOrderNo(orderNo);
            //更新数据库
            restDmSchedulerSeatClient.qdtxModifyDmSchedulerSeat(dmSchedulerSeat);
            //计算总价格
            DmSchedulerSeatPrice dmSchedulerSeatPrice = restDmSchedulerSeatPriceClient.getDmSchedulerSeatPriceBySchedulerIdAndArea(
                    dmSchedulerSeat.getScheduleId(),
                    dmSchedulerSeat.getAreaLevel());
            totalAmount += dmSchedulerSeatPrice.getPrice();
            //保存座位价格信息
            doublePrices[i] = dmSchedulerSeatPrice.getPrice();
        }
        //生成订单信息
        DmOrder dmOrder = new DmOrder();
        dmOrder.setOrderNo(orderNo);
        BeanUtils.copyProperties(orderNo, dmOrder);
        dmOrder.setItemName(dmItem.getItemName());
        dmOrder.setOrderType(Constants.SchedulerSeatStatus.SchedulerSeat_TOPAY);
        dmOrder.setTotalCount(seatArray.length);
        //如果勾选了保险，则增加到总金额里
        if (orderVo.getIsNeedInsurance() == Constants.OrderStatus.ISNEEDINSURANCE_YES) {
            totalAmount += Constants.OrderStatus.NEEDINSURANCE_MONEY;
        }
        dmOrder.setInsuranceAmount(Constants.OrderStatus.NEEDINSURANCE_MONEY);
        dmOrder.setCreatedTime(new Date());
        //更新插入订单数据,并且放回当前订单数据的主键ID
        Long orderID = 0L;
        try {
            orderID = restDmOrderClient.qdtxAddDmOrder(dmOrder);
        } catch (Exception e) {
            e.printStackTrace();
            //创建订单失败，重置之前的订单座位信息
            sendResetSeatMsg(dmSchedulerSeat.getScheduleId(), seatArray);
            throw new BaseException(OrderErrorCode.ORDER_NO_DATA);
        }

        //更新相关关联用户
        String[] linkIds = orderVo.getLinkIds().split(",");
        for (int i = 0; i < linkIds.length; i++) {
            //查询关联用户信息
            DmLinkUser dmLinkUser = restDmLinkUserClient.getDmLinkUserById(Long.parseLong(linkIds[i]));
            if (EmptyUtils.isEmpty(dmLinkUser)) {
                //创建订单失败，重置之前的订单座位信息
                sendResetSeatMsg(dmSchedulerSeat.getScheduleId(), seatArray);
                //无法添加联系人，需要删除之前创建的订单
                sendDelOrderMsg(orderID);
                //重置订单明细关联人信息
                sendResetLinkUser(orderID);
                throw new BaseException(OrderErrorCode.ORDER_NO_DATA);
            }
            DmOrderLinkUser dmOrderLinkUser = new DmOrderLinkUser();
            dmOrderLinkUser.setOrderId(orderID);
            dmOrderLinkUser.setLinkUserId(dmLinkUser.getId());
            dmOrderLinkUser.setLinkUserName(dmLinkUser.getName());
            dmOrderLinkUser.setX(Integer.parseInt(seatArray[i].split("_")[0]));
            dmOrderLinkUser.setY(Integer.parseInt(seatArray[i].split("_")[1]));
            dmOrderLinkUser.setPrice(doublePrices[i]);
            dmOrderLinkUser.setCreatedTime(new Date());
            try {
                restDmOrderLinkUserClient.qdtxAddDmOrderLinkUser(dmOrderLinkUser);
            } catch (Exception e) {
                e.printStackTrace();
                //创建订单失败，重置之前的订单座位信息
                sendResetSeatMsg(dmSchedulerSeat.getScheduleId(), seatArray);
                //无法添加联系人，需要删除之前创建的订单
                sendDelOrderMsg(orderID);
                //重置订单明细关联人信息
                sendResetLinkUser(orderID);
            }
        }
        //将座位锁定
        setSeatLock(orderVo,seatArray);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderNo", orderNo);
        return DtoUtil.returnDataSuccess(jsonObject);
    }

    /**
     * 将座位锁定,信息保存到redis中
     * @param orderVo
     * @param seatArray
     */
    private void setSeatLock(CreateOrderVo orderVo, String[] seatArray) {
        redisUtils.unlock(String.valueOf(orderVo.getSchedulerId()));
        for (int i = 0; i < seatArray.length; i++) {
            redisUtils.set(orderVo.getSchedulerId()+":"+seatArray[i],"lock");
        }

    }

    /**
     * 发送需要重置联系人的消息
     *
     * @param orderID
     */
    private void sendResetLinkUser(Long orderID) {
        rabbitTemplate.convertAndSend(Constants.RabbitQueueName.TOPIC_EXCHANGE,
                Constants.RabbitQueueName.TO_RESET_LINKUSER_QUQUE,
                orderID,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        //消息持久化，避免消息服务宕机后消息丢失
                        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                        return message;
                    }
                });
    }

    /**
     * 发送需要删除订单的消息
     *
     * @param orderID
     */
    private void sendDelOrderMsg(Long orderID) {
        rabbitTemplate.convertAndSend(Constants.RabbitQueueName.TOPIC_EXCHANGE,
                Constants.RabbitQueueName.TO_DEL_ORDER_QUQUE,
                orderID,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        //消息持久化，避免消息服务宕机后消息丢失
                        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                        return message;
                    }
                });
    }

    /**
     * 发送需要重置座位的消息
     *
     * @param scheduleId
     * @param seatArray
     */
    private void sendResetSeatMsg(Long scheduleId, String[] seatArray) {
        Map<String, Object> resetSeatMap = new HashMap<>();
        resetSeatMap.put("scheduleId", scheduleId);
        resetSeatMap.put("seats", seatArray);
        rabbitTemplate.convertAndSend(Constants.RabbitQueueName.TOPIC_EXCHANGE,
                Constants.RabbitQueueName.TO_RESET_SEAT_QUQUE,
                resetSeatMap,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        //消息持久化，避免消息服务宕机后消息丢失
                        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                        return message;
                    }
                });
    }

    /**
     * 重置座位状态信息
     *
     * @param resetSeatMap
     * @param message
     * @param channel
     */
    @RabbitListener(queues = Constants.RabbitQueueName.TO_RESET_SEAT_QUQUE)
    public void resetSeatMsg(Map<String, Object> resetSeatMap, Message message, Channel channel) {
        Long scheduleId = (Long) resetSeatMap.get("scheduleId");
        String[] seatArray = (String[]) resetSeatMap.get("seats");
        try {
            for (int i = 0; i < seatArray.length; i++) {
                //更新每个座位信息
                String[] seats = seatArray[i].split("_");
                DmSchedulerSeat dmSchedulerSeat = restDmSchedulerSeatClient.getDmSchedulerSeatByOrder(
                        scheduleId,
                        Integer.parseInt(seats[0]),
                        Integer.parseInt(seats[1]));
                dmSchedulerSeat.setStatus(1);
                dmSchedulerSeat.setUserId(null);
                dmSchedulerSeat.setOrderNo(null);
                restDmSchedulerSeatClient.qdtxModifyDmSchedulerSeat(dmSchedulerSeat);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * 删除订单
     *
     * @param orderId
     * @param message
     * @param channel
     */
    @RabbitListener(queues = Constants.RabbitQueueName.TO_DEL_ORDER_QUQUE)
    public void delOrderMsg(Long orderId, Message message, Channel channel) {
        try {
            restDmOrderClient.deleteDmOrderById(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 重置订单明细表关联人信息
     *
     * @param orderId
     * @param message
     * @param channel
     */
    @RabbitListener(queues = Constants.RabbitQueueName.TO_RESET_LINKUSER_QUQUE)
    public void delOrderlLinkUserMsg(Long orderId, Message message, Channel channel) {
        try {
            restDmOrderLinkUserClient.deleteDmOrderLinkUserByOrderId(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}
