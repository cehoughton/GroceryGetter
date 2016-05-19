package com.epicodus.grocerygetter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.Recipe;
import com.epicodus.grocerygetter.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by Guest on 5/19/16.
 */
public class FirebaseRecipeListAdapter extends FirebaseRecyclerAdapter<RecipeViewHolder, Recipe> {

    public FirebaseRecipeListAdapter(Query query, Class<Recipe> itemClass) {
        super (query, itemClass);
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        return new RecipeViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        holder.bindRecipe(getItem(position));
    }

    @Override
    protected void itemAdded(Recipe item, String key, int position) {

    }

    @Override
    protected void itemChanged(Recipe oldItem, Recipe newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Recipe item, String key, int position) {

    }

    @Override
    protected void itemMoved(Recipe item, String key, int oldPosition, int newPosition) {

    }
}
