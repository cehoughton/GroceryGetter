package com.epicodus.grocerygetter.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.epicodus.grocerygetter.Constants;
import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.adapters.FirebaseBinListAdapter;
import com.epicodus.grocerygetter.models.Bin;
import com.epicodus.grocerygetter.models.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedBinActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseBinRef;
    private FirebaseBinListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private int mBinID;
    private Bin mBin;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

//    Firebase mainRef = new Firebase(Constants.FIREBASE_URL);
//    String uid = mainRef.getAuth().getUid();
//    Firebase ref = new Firebase(Constants.FIREBASE_URL_USERS).child(uid);
//    ref.child("binType").setValue(mBin.getPushID());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bin);
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
                        Log.d("Bin in SavedBinActivity", mBin.getSize());
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

    private void setUpFirebaseQuery() {

    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseBinListAdapter(mQuery, Bin.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
