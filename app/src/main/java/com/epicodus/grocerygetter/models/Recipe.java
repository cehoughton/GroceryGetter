package com.epicodus.grocerygetter.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Guest on 4/28/16.
 */
@Parcel
public class Recipe {
    String title;
    String imageUrl;


    private String pushId;

    public Recipe() {
    }

    public Recipe(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}