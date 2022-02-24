package com.buddies.affiliate.Model;

public class SliderModel {

    String url,poster,id;

    public SliderModel(String url, String poster, String id) {
        this.url = url;
        this.poster = poster;
        this.id = id;
    }

    public SliderModel() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
