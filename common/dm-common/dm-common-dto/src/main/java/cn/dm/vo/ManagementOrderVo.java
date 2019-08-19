package cn.dm.vo;

/**
 * 订单管理传输VO
 */
public class ManagementOrderVo {
    //订单ID
    private Long id;
    //订单号
    private String orderNo;
    //商品名称
    private String itemName;
    //总价
    private Double totalAmount;
    //订单类型(0:未支付 -1:支付超时/支付取消 2:已支付)
    private Integer orderType;
    //购买数目
    private Integer num;
    //商品单价(x1_y1_price,x2_y2_price)
    private String unitPrice;
    //购买时间
    private String sellTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSellTime() {
        return sellTime;
    }

    public void setSellTime(String sellTime) {
        this.sellTime = sellTime;
    }
}
