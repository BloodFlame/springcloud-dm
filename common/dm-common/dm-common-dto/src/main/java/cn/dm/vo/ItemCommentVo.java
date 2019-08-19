package cn.dm.vo;

import java.util.Date;

/**
 * 剧评查询VO
 */
public class ItemCommentVo {

    //商品Id
    private Long itemId;

    //评论用户ID
    private Long userId;

    //评论用户名称
    private String userName;

    //用户头像
    private String imgUrl;

    //评分(1-10)
    private Integer score;

    //剧评
    private String content;

    //更新时间
    private String createdTime;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
