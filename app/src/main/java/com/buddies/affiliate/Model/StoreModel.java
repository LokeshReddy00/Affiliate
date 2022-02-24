package com.buddies.affiliate.Model;

public class StoreModel {

    private String store,location,call,img;

    public StoreModel(String store, String location, String call, String img) {
        this.store = store;
        this.location = location;
        this.call = call;
        this.img = img;
    }

    public StoreModel() {
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
