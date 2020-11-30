package com.drc.zfgc.flink;


import java.io.Serializable;

public class Item implements Serializable {
    public Integer i_item_sk;
    public Double i_current_price;
    private int url_id;
    private String category;
    private String category_url;
    private String purchaser;
    private String notice;
    private String pubtime;
    private String region;
    private String title;
    private String agency;
    private String url;
    private String content;
    private String hashcode;
    private String put_time;

    public int getUrl_id() {
        return url_id;
    }

    public void setUrl_id(int url_id) {
        this.url_id = url_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory_url() {
        return category_url;
    }

    public void setCategory_url(String category_url) {
        this.category_url = category_url;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getPut_time() {
        return put_time;
    }

    public void setPut_time(String put_time) {
        this.put_time = put_time;
    }

    public Item() {
    }

    public Item(Integer i_item_sk, Double i_current_price) {
        this.i_item_sk = i_item_sk;
        this.i_current_price = i_current_price;
    }

    public Integer getI_item_sk() {
        return i_item_sk;
    }

    public void setI_item_sk(Integer i_item_sk) {
        this.i_item_sk = i_item_sk;
    }

    public Double getI_current_price() {
        return i_current_price;
    }

    public void setI_current_price(Double i_current_price) {
        this.i_current_price = i_current_price;
    }
}
