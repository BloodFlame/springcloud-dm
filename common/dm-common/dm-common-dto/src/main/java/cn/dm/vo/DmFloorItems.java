package cn.dm.vo;
import java.io.Serializable;
import java.util.List;

/***
 * 不同楼层的数据封装
 */
public class DmFloorItems implements Serializable{
    private Integer floor;
    private String itemTypeName;
    private Long itemTypeId;
    private List<DmItemVo> items;

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public List<DmItemVo> getItems() {
        return items;
    }

    public void setItems(List<DmItemVo> items) {
        this.items = items;
    }
}
