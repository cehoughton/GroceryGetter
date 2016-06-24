package com.epicodus.grocerygetter.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.grocerygetter.Constants;
import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.adapters.BinPagerAdapter;
import com.epicodus.grocerygetter.adapters.FirebaseBinListAdapter;
import com.epicodus.grocerygetter.models.Bin;
import com.epicodus.grocerygetter.models.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedBinActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseBinRef;
    private FirebaseBinListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private int mBinID;
    private Bin mBin;
   // @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_bin);
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String uid = mSharedPreferences.getString(Constants.KEY_UID, null);
        mFirebaseBinRef = new Firebase(Constants.FIREBASE_URL_USERS).child(uid);

        mFirebaseBinRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                mBinID = user.getBinType();
                Firebase binRef = new Firebase(Constants.FIREBASE_URL_BINS).child(mBinID + "");
                binRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mBin = dataSnapshot.getValue(Bin.class);
                        Log.d("Bin in SavedBinActivity", String.valueOf(mBin.getContents()));
                        List<String> binContents = mBin.getContents();

                        ArrayAdapter<String> itemsAdapter;
                        itemsAdapter = new ArrayAdapter<String>(SavedBinActivity.this, android.R.layout.simple_list_item_1, binContents);


                        mListView.setAdapter(itemsAdapter);

                    }


                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {}

        });


    }

    private void setUpFirebaseQuery() {

    }


}
