package com.epicodus.grocerygetter;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mLogInButton;
    private EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mLogInButton = (Button) findViewById(R.id.logInButton);
          mLogInButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String name = mNameEditText.getText().toString();
                  Log.d(TAG, name);
                  Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                  intent.putExtra("name", name);
                  startActivity(intent);
              }
          });
    }
}
