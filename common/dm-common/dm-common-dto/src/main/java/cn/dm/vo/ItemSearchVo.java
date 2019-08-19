package cn.dm.vo;

import java.io.Serializable;

/***
 * 商品查询返回的VO
 */
public class ItemSearchVo implements Serializable{
    private Long id;
    private String imgUrl;
    private String areaName;
    private String  itemName;
    private  String abstractMessage;
    private String startTime;
    private String endTime;
    private Double minPrice;
    private Double maxPrice;
    private String address;
    private String latitude;
    private String longitude;
    private Long itemTypeId1;
    private Long itemTypeId2;
    private Long areaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAbstractMessage() {
        return abstractMessage;
    }

    public void setAbstractMessage(String abstractMessage) {
        this.abstractMessage = abstractMessage;
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

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
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

    public Long getItemTypeId1() {
        return itemTypeId1;
    }

    public void setItemTypeId1(Long itemTypeId1) {
        this.itemTypeId1 = itemTypeId1;
    }

    public Long getItemTypeId2() {
        return itemTypeId2;
    }

    public void setItemTypeId2(Long itemTypeId2) {
        this.itemTypeId2 = itemTypeId2;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
}
