package cn.dm.vo;

import java.util.Date;

/**
 * Created by Administrator on 2018-5-21.
 */
public class LinkUserVo{
    //对应用户表的主键
    private Long userId;
    //联系人姓名
    private String name;
    //身份证号
    private String idCard;
    //证件类型(0:身份证 1:护照)
    private Integer cardType;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
    //get set 方法
    public void setName (String  name){
        this.name=name;
    }
    public  String getName(){
        return this.name;
    }
    public void setIdCard (String  idCard){
        this.idCard=idCard;
    }
    public  String getIdCard(){
        return this.idCard;
    }
    public void setCardType (Integer  cardType){
        this.cardType=cardType;
    }
    public  Integer getCardType(){
        return this.cardType;
    }
    public void setCreatedTime (Date  createdTime){
        this.createdTime=createdTime;
    }
    public  Date getCreatedTime(){
        return this.createdTime;
    }
    public void setUpdatedTime (Date  updatedTime){
        this.updatedTime=updatedTime;
    }
    public  Date getUpdatedTime(){
        return this.updatedTime;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
