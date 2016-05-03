package com.epicodus.grocerygetter.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Guest on 4/28/16.
 */
@Parcel
public class Recipe {
    private String mTitle;
    private String mImageUrl;

public Recipe() {}

public Recipe(String title, String imageUrl) {
    this.mTitle = title;
    this.mImageUrl = imageUrl;
}

    public String getTitle() {
        return mTitle;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
