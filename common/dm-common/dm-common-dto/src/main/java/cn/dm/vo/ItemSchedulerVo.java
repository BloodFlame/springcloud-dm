package cn.dm.vo;

/**
 * 商品排期传输VO
 */
public class ItemSchedulerVo {
    //排期Id
    private Long id;
    //排期名称
    private String title;
    //商品Id
    private Long itemId;
    //开始日期
    private String startTime;
    //结束日期
    private String endTime;
    //剧场ID
    private Long cinemaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }
}
