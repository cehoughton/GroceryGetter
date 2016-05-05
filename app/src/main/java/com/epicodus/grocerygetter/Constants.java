package com.epicodus.grocerygetter;

/**
 * Created by Guest on 4/28/16.
 */
public class Constants {
    public static final String API_KEY = BuildConfig.API_KEY;

    public static final String FOOD_BASE_URL ="http://food2fork.com/api/search";
    public static final String FOOD_RECIPE_QUERY_PARAMETER = "q";

    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
}
