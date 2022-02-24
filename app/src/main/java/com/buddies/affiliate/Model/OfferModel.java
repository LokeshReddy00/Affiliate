package com.buddies.affiliate.Model;

public class OfferModel {

    String banner,url,id,percent,info,code;

    public OfferModel(String banner, String url, String id, String percent, String info, String code) {
        this.banner = banner;
        this.url = url;
        this.id = id;
        this.percent = percent;
        this.info = info;
        this.code = code;
    }

    public OfferModel() {
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
