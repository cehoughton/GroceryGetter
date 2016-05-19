package com.epicodus.grocerygetter.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.grocerygetter.Constants;
import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewRecipeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mProfileTextView;
    private Firebase mFirebaseRef;
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.savedRecipesButton) Button mSavedRecipesButton;
    @Bind(R.id.findRecipesButton)
    Button mFindRecipesButton;
    @Bind(R.id.editFoodText) EditText mEditFoodText;
    private ValueEventListener mUserRefListener;
    private Firebase mUserRef;
    private String mUId;
    private SharedPreferences mSharedPrefrences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        ButterKnife.bind(this);
        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
        mSavedRecipesButton.setOnClickListener(this);
        mFindRecipesButton.setOnClickListener(this);
        mSharedPrefrences = PreferenceManager.getDefaultSharedPreferences(this);
        mUId = mSharedPrefrences.getString(Constants.KEY_UID, null);
        mUserRef = new Firebase(Constants.FIREBASE_URL_USERS).child(mUId);

       mUserRefListener = mUserRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               User user = dataSnapshot.getValue(User.class);

           }

           @Override
           public void onCancelled(FirebaseError firebaseError) {

           }
       });
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRecipesButton) {
            String recipe = mEditFoodText.getText().toString();
            Intent intent = new Intent(NewRecipeActivity.this, RecipesListActivity.class);
            intent.putExtra("recipe", recipe);
            startActivity(intent);
        }

        if (v == mSavedRecipesButton) {
          Intent intent = new Intent(NewRecipeActivity.this, SavedRecipeListActivity.class);
            startActivity(intent);
        }
    }


    }
