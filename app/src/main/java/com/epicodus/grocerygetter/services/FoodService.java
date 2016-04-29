package com.epicodus.grocerygetter.services;

import android.util.Log;

import com.epicodus.grocerygetter.Constants;
import com.epicodus.grocerygetter.models.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 4/28/16.
 */
public class FoodService {
    public static void findRecipes(String recipe, Callback callback) {
        String API_KEY = Constants.API_KEY;
        Log.d("RECIPE", recipe);

        OkHttpClient  client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.FOOD_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("key", API_KEY);
        urlBuilder.addQueryParameter(Constants.FOOD_RECIPE_QUERY_PARAMETER, recipe);

        Log.d("tag", ""+urlBuilder);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Recipe> processResults(Response response) {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject foodJSON = new JSONObject(jsonData);
                JSONArray recipesJSON = foodJSON.getJSONArray("recipes");
                for (int i = 0; i < recipesJSON.length(); i++) {
                    JSONObject recipeJSON = recipesJSON.getJSONObject(i);
                    String title = recipeJSON.getString("title");
                    String imageUrl = recipeJSON.getString("image_url");

                    Recipe recipe = new Recipe(title, imageUrl);
                    recipes.add(recipe);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recipes;
    }


}
