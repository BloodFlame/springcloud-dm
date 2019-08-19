package cn.dm.vo;
import java.io.Serializable;

/***
 * 抢购商品消息
 */
public class DmItemMessageVo implements Serializable{
    //商品id
    private String itemId;
    //用户编号
    private String userId;
    //抢购状态
    private String status;
    //金额
    private double amount;
    //交易号
    private String tradeNo;
    //订单号
    private String orderNo;
    //支付方式（1：微信，2：支付宝）
    private Integer payMethod;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }
}
