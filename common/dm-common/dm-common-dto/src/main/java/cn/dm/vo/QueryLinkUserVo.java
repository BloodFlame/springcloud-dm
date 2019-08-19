package cn.dm.vo;

/**
 * Created by Administrator on 2018-6-1.
 */
public class QueryLinkUserVo {
    //表的主键
    private Long id;
    //联系人姓名
    private String name;
    //身份证号
    private String idCard;
    //证件类型(0:身份证 1:护照)
    private Integer cardType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }
}
