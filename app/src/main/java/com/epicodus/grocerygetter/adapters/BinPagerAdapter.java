package com.epicodus.grocerygetter.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.grocerygetter.models.Bin;
import com.epicodus.grocerygetter.ui.BinDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 5/17/16.
 */
public class BinPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Bin> mBins;

    public BinPagerAdapter(FragmentManager fm, ArrayList<Bin> bins) {
        super(fm);
        mBins = bins;
    }

    @Override
    public Fragment getItem(int position) {
        return BinDetailFragment.newInstance(mBins.get(position));
    }

    @Override
    public int getCount() {
        return mBins.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBins.get(position).getSize();
    }
}
