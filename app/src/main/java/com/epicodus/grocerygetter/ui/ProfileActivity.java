package com.epicodus.grocerygetter.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.grocerygetter.R;

public class ProfileActivity extends AppCompatActivity {

    private String[] produceBin = new String[] {"carrots", "squash", "kale", "apples", "pears", "strawberries", "cilantro", "potatoes", "green beans", "lettuce", "shitake mushrooms", "oranges"};
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, produceBin);
        mListView.setAdapter(adapter);


    }
}
