package com.starlingsoftwares.mymanagement.model;

public class Home {
    String place;
    String id;
    int image;

    public Home() {
    }

    public Home(String place, int image) {
        this.place = place;
        this.image = image;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
