package com.epicodus.grocerygetter.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.adapters.BinPagerAdapter;
import com.epicodus.grocerygetter.models.Bin;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BinDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private BinPagerAdapter adapterViewPager;
    ArrayList<Bin> mBins = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin_detail);
        ButterKnife.bind(this);
        mBins = Parcels.unwrap(getIntent().getParcelableExtra("bins"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new BinPagerAdapter(getSupportFragmentManager(), mBins);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
