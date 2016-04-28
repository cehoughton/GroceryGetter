package com.epicodus.grocerygetter;

/**
 * Created by Guest on 4/28/16.
 */
public class Recipe {
    private String mTitle;
    private String mImageUrl;

public Recipe(String title, String imageUrl) {
    this.mTitle = title;
    this.mImageUrl = imageUrl;
}

    public String getTitle() {
        return mTitle;
    }

    public String getImageUrl() {
        return mImageUrl
    }
}
