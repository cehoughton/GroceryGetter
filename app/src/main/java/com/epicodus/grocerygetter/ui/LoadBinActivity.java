package com.epicodus.grocerygetter.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.grocerygetter.Constants;
import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.Bin;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoadBinActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = LoadBinActivity.class.getSimpleName();

//    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.loadBinButton)
    Button mLoadBinButton;
    @Bind(R.id.binNameType)
    EditText mBinNameType;
    @Bind(R.id.loadBinContent) EditText mLoadBinContent;

    private Bin mBin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_bin);
        ButterKnife.bind(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mLoadBinButton) {
          Firebase ref = new Firebase(Constants.FIREBASE_URL_BINS);
            ref.push().setValue(mBin);
        }
    }
}
