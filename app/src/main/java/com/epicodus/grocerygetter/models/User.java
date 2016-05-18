package com.epicodus.grocerygetter.models;

import android.support.annotation.Nullable;

/**
 * Created by Guest on 5/4/16.
 */
public class User {
    private String name;
    private String email;



    public void setBinType( int binType) {
        this.binType = binType;
    }


    private int binType;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



    public int getBinType() {
        return binType;
    }

}
