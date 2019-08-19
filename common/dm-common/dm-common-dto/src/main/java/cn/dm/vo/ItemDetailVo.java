package cn.dm.vo;

/**
 * 商品详情数据传递VO
 */
public class ItemDetailVo {

    //商品主键
    private Long id;
    //商品简介
    private String abstractMessage;
    //节目名称
    private String itemName;
    //一级分类ID
    private Long itemType1Id;
    //一级分类名称
    private String itemType1Name;
    //二级分类ID
    private Long itemType2Id;
    //二级分类名称
    private String itemType2Name;
    //区域id
    private Long areaId;
    //区域名称
    private String areaName;
    //演出开始时间
    private String startTime;
    //演出结束时间
    private String endTime;
    //状态(1:项目待定2:预售/预订3:开始售票4:演出开始)
    private String state;
    //基础描述
    private String basicDescription;
    //项目描述
    private String projectDescription;
    //温馨提示
    private String reminderDescription;
    //图片地址
    private String imgUrl;
    //剧场Id
    private Long cinemaId;
    //剧场地址
    private String address;
    //剧场经度
    private String latitude;
    //剧场纬度
    private String longitude;
    //平均评分
    private Double avgScore;
    //评论数目
    private Integer commentCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbstractMessage() {
        return abstractMessage;
    }

    public void setAbstractMessage(String abstractMessage) {
        this.abstractMessage = abstractMessage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemType1Id() {
        return itemType1Id;
    }

    public void setItemType1Id(Long itemType1Id) {
        this.itemType1Id = itemType1Id;
    }

    public String getItemType1Name() {
        return itemType1Name;
    }

    public void setItemType1Name(String itemType1Name) {
        this.itemType1Name = itemType1Name;
    }

    public Long getItemType2Id() {
        return itemType2Id;
    }

    public void setItemType2Id(Long itemType2Id) {
        this.itemType2Id = itemType2Id;
    }

    public String getItemType2Name() {
        return itemType2Name;
    }

    public void setItemType2Name(String itemType2Name) {
        this.itemType2Name = itemType2Name;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBasicDescription() {
        return basicDescription;
    }

    public void setBasicDescription(String basicDescription) {
        this.basicDescription = basicDescription;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getReminderDescription() {
        return reminderDescription;
    }

    public void setReminderDescription(String reminderDescription) {
        this.reminderDescription = reminderDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
