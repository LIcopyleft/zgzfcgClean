package com.drc.zfgc.model;

import lombok.Data;

@Data
public class CNGovDataUrl {
    private Integer urlId;

    private String purchaser;
    private String supplier;
    private String contractSigningTime;


    private String category;
    private String items;


    private String notice;
    //公告类型
    private String type;

    private String pubtime;

    private String address;
    private String region;

    private String url;

    private String title;

    private String agency;

    private String hashcode;

    private String content;

    /*
     * @description  表设计有误,字段名修改
     */
    private String categoryUrl;


    public String getCategoryUrl() {
        return items;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.items = categoryUrl;
    }

    @Override
    public String toString() {
        return "CNGovDataUrl{" +
                "urlId=" + urlId +
                ", purchaser='" + purchaser + '\'' +
                ", category='" + category + '\'' +
                ", items='" + items + '\'' +
                ", notice='" + notice + '\'' +
                ", type='" + type + '\'' +
                ", pubtime='" + pubtime + '\'' +
                ", address='" + address + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", agency='" + agency + '\'' +
              //  ", hashcode='" + hashcode + '\'' +
                '}';
    }
}
