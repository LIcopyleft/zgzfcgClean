package com.drc.zfgc.model;

public class Items {
    private String itemId;

    private String itemName;

    private String parentItemId;

    private String itemLevel;

    private String itemFullpath;

    private String itemFullname;

    private String isvalued;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId == null ? null : parentItemId.trim();
    }

    public String getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(String itemLevel) {
        this.itemLevel = itemLevel == null ? null : itemLevel.trim();
    }

    public String getItemFullpath() {
        return itemFullpath;
    }

    public void setItemFullpath(String itemFullpath) {
        this.itemFullpath = itemFullpath == null ? null : itemFullpath.trim();
    }

    public String getItemFullname() {
        return itemFullname;
    }

    public void setItemFullname(String itemFullname) {
        this.itemFullname = itemFullname == null ? null : itemFullname.trim();
    }

    public String getIsvalued() {
        return isvalued;
    }

    public void setIsvalued(String isvalued) {
        this.isvalued = isvalued == null ? null : isvalued.trim();
    }
}
