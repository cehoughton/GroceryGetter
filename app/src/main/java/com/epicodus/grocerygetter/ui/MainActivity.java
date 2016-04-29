package com.epicodus.grocerygetter.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.grocerygetter.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.logInButton) Button mLogInButton;
    @Bind(R.id.nameEditText) EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLogInButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == mLogInButton) {
            String name = mNameEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, NewRecipeActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }

    }
}
