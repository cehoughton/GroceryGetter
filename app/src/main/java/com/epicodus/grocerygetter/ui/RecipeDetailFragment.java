package com.epicodus.grocerygetter.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.grocerygetter.Constants;
import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.Recipe;
import com.firebase.client.Firebase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeDetailFragment extends Fragment implements View.OnClickListener {
    private SharedPreferences mSharedPreferences;
    @Bind(R.id.recipeImageView) ImageView mImageLabel;
    @Bind(R.id.recipeTitleTextView) TextView mTitleLabel;
    @Bind(R.id.saveRecipeButton) TextView mSaveRecipeButton;

    private Recipe mRecipe;

    public static RecipeDetailFragment newInstance(Recipe recipe) {
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);
        mSaveRecipeButton.setOnClickListener(this);

        Picasso.with(view.getContext()).load(mRecipe.getImageUrl()).into(mImageLabel);
        mTitleLabel.setText(mRecipe.getTitle());
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSaveRecipeButton) {
            String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
            Firebase userRecipesFirebaseRef = new Firebase(Constants.FIREBASE_URL_RECIPES).child(userUid);
            Firebase pushRef = userRecipesFirebaseRef.push();
            String recipePushId = pushRef.getKey();
            mRecipe.setPushId(recipePushId);
            pushRef.setValue(mRecipe);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }

}
