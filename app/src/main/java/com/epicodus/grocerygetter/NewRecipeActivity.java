package com.epicodus.grocerygetter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewRecipeActivity extends AppCompatActivity {
    private TextView mProfileTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        mProfileTextView = (TextView) findViewById(R.id.profileTextView);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mProfileTextView.setText("Hello " + name);
    }
}
