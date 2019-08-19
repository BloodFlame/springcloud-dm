package cn.dm.vo;

/**
 * Created by Administrator on 2018-5-24.
 */
public class OrderPayStatusVo {
    //订单编号
    private String orderNo;
    //订单的支付状态
    private Integer orderType;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
