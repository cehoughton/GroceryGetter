package com.epicodus.grocerygetter.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.Recipe;
import com.epicodus.grocerygetter.ui.RecipeDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/19/16.
 */
 public class RecipeViewHolder extends RecyclerView.ViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    @Bind(R.id.recipeImageView)
    ImageView mRecipeImageView;
    @Bind(R.id.recipeTitleTextView)
    TextView mRecipeTitleTextView;

    private Context mContext;
    private ArrayList<Recipe> mRecipes = new ArrayList<>();

    public RecipeViewHolder(View itemView, ArrayList<Recipe> recipes) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mRecipes = recipes;
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, RecipeDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("recipes", Parcels.wrap(mRecipes));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindRecipe(Recipe recipe) {
        Picasso.with(mContext).load(recipe.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT).centerCrop()
                .into(mRecipeImageView);

        mRecipeTitleTextView.setText(recipe.getTitle());


    }
}

