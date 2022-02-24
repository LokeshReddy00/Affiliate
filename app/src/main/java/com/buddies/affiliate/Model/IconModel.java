package com.buddies.affiliate.Model;

public class IconModel {

    String name,icon,link,category,url;


    public IconModel(String name, String icon, String link, String category, String url) {
        this.name = name;
        this.icon = icon;
        this.link = link;
        this.category = category;
        this.url = url;
    }

    public IconModel() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
