package cn.dm.vo;

import java.util.Date;
import java.util.List;

/***`
 * 用于首页数据回传
 */
public class DmItemTypeVo {
    //主键
    private Long id;
    //类型名称
    private String itemType;
    //分类级别;select;(1:1级,2:2级)
    private String level;
    //父级类型
    private Long parent;
    //类别别名
    private String aliasName;
    //页面模板类型
    private String key;
    //节目类型集合
    private List<DmItemTypeVo> children;
    //热门节目
    private List<HotItemVo> hotItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<DmItemTypeVo> getChildren() {
        return children;
    }

    public void setChildren(List<DmItemTypeVo> children) {
        this.children = children;
    }

    public List<HotItemVo> getHotItems() {
        return hotItems;
    }

    public void setHotItems(List<HotItemVo> hotItems) {
        this.hotItems = hotItems;
    }
}
