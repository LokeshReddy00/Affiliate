package com.buddies.affiliate.Model;

public class AppsModel {

    String id, url, name, icon,category;

    public AppsModel(String id, String url, String name, String icon, String category) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.icon = icon;
        this.category = category;
    }

    public AppsModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
