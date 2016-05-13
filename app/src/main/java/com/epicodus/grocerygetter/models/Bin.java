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
    List<String> content = new ArrayList<>();
    private String pushId;

    public Bin() {}

    public Bin(String size, ArrayList<String> content) {
        this.size = size;
        this.content = content;
    }

    public String getSize() {
        return size;
    }

    public List<String> getContent() {
        return content;
    }


    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}

