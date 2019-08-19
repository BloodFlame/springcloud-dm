package cn.dm.common;

import java.text.ParseException;
import java.util.Date;

public class OrderUtils {

    /**
     * 生成订单号
     *
     * @return
     */
    public static String createOrderNo() {
        StringBuilder md5String = new StringBuilder();

        md5String.append(System.currentTimeMillis());
        md5String.append(Math.random() * 1000000);
        String md5 = MD5.getMd5(md5String.toString(), 6);
        //生成订单编号
        StringBuilder orderNo = new StringBuilder();
        try {
            orderNo.append(DateUtil.format(new Date(), "yyyyMMddHHmmss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orderNo.append(md5);
        return orderNo.toString();
    }

    public static void main(String[]  args){
       System.out.println(OrderUtils.createOrderNo());
    }
}
