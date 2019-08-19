package cn.dm.vo;

import java.io.Serializable;

public class SeatPriceVo implements Serializable{

    private String areaLevelName;

    private Double price;

    private Integer areaLevel;

    public String getAreaLevelName() {
        if(areaLevel==1){
            return "A";
        }else if(areaLevel==2){
            return "B";
        }else if(areaLevel==3){
            return "C";
        }else{
            return "N";
        }
    }

    public void setAreaLevelName(String areaLevelName) {
        this.areaLevelName = areaLevelName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }


}
