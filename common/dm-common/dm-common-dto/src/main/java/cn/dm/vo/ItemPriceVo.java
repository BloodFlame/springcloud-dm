package cn.dm.vo;

/**
 * 商品排期对应价格传输VO
 */
 
 
public class ItemPriceVo {
    //商品价格Id
    private Long id;
    //排期Id
    private Long scheduleId;
    //价格
    private Double price;
    //座位状态(0:没座位 1:有座位)
    private Integer isHaveSeat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIsHaveSeat() {
        return isHaveSeat;
    }

    public void setIsHaveSeat(Integer isHaveSeat) {
        this.isHaveSeat = isHaveSeat;
    }
}
