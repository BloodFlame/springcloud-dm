package cn.dm.vo;

import java.util.Date;

/**
 * 订单创建传输Vo
 */
public class CreateOrderVo {

    //下单用户Id
    private Long userId;
    //排期ID
    private Long schedulerId;
    //剧集Id(冗余)
    private Long itemId;
    //下单关联用户
    private String linkIds;
    //剧场ID
    private Long cinemaId;
    //0:WEB端 1:手机端 2:其他客户端
    private Integer sourceType;
    //是否需要发票（0：不需要 1：需要）
    private Integer isNeedInvoice;
    //发票类型（0：个人 1：公司）
    private Integer invoiceType;
    //发票抬头
    private String invoiceHead;
    //发票号
    private String invoiceNo;
    //是否需要保险(0：不需要 1:需要)
    private Integer isNeedInsurance;
    //座位坐标（x1_y1,x2_y2,x3_y3）
    private String seatPositions;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(Long schedulerId) {
        this.schedulerId = schedulerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getIsNeedInvoice() {
        return isNeedInvoice;
    }

    public void setIsNeedInvoice(Integer isNeedInvoice) {
        this.isNeedInvoice = isNeedInvoice;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceHead() {
        return invoiceHead;
    }

    public void setInvoiceHead(String invoiceHead) {
        this.invoiceHead = invoiceHead;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Integer getIsNeedInsurance() {
        return isNeedInsurance;
    }

    public void setIsNeedInsurance(Integer isNeedInsurance) {
        this.isNeedInsurance = isNeedInsurance;
    }

    public String getSeatPositions() {
        return seatPositions;
    }

    public void setSeatPositions(String seatPositions) {
        this.seatPositions = seatPositions;
    }

    public String getLinkIds() {
        return linkIds;
    }

    public void setLinkIds(String linkIds) {
        this.linkIds = linkIds;
    }
}
