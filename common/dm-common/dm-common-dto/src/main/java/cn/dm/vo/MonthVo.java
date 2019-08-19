package cn.dm.vo;

import java.util.List;

/**
 * 按月份组装数据
 */
public class MonthVo {
    //当前日期（天）
    private String day;
    //当前日期的节目列表
    private List<ParentAndChildVo> itemList;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<ParentAndChildVo> getItemList() {
        return itemList;
    }

    public void setItemList(List<ParentAndChildVo> itemList) {
        this.itemList = itemList;
    }
}
