package com.epicodus.grocerygetter.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.grocerygetter.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyBinActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Firebase m
    @Bind(R.id.myBinButton) Button mMyBinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bin);
        ButterKnife.bind(this);

        mMyBinButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mMyBinButton) {

        }
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        ButterKnife.bind(this);

        mFindRecipesButton.setOnClickListener(this);

        mProfileTextView = (TextView) findViewById(R.id.profileTextView);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mProfileTextView.setText("Hello " + name);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRecipesButton) {
            String recipe = mEditFoodText.getText().toString();
            Intent intent = new Intent(NewRecipeActivity.this, RecipesListActivity.class);
            intent.putExtra("recipe", recipe);
            startActivity(intent);
        }
    }
}
