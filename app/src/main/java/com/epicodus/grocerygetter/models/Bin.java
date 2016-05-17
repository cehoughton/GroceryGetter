package com.epicodus.grocerygetter.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Guest on 5/6/16.
 */
@Parcel
public class Bin {
    String size;
    List<String> contents = new ArrayList<>();
    private String pushID;

    public Bin() {}

    public Bin(String size, ArrayList<String> content) {
        this.size = size;
        this.contents = content;
    }

    public String getSize() {
        return size;
    }

    public List<String> getContents() {
        return contents;
    }

    public String getPushID() {
        return  pushID;
    }

    public void setPushID(String pushID) {
        this.pushID = pushID;
    }



}

