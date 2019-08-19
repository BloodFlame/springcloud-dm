package cn.dm.vo;

/**
 * 亲子页轮播图
 */
public class SlideShowVo {
    //商品主键
    private Long id;
    //节目名称
    private String itemName;
    //最低价格
    private Double minPrice;
    //热门节目宣传照片
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
