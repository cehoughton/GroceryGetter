package com.epicodus.grocerygetter.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.Bin;
import org.parceler.Parcels;

import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/13/16.
 */
public class BinListAdapter extends RecyclerView.Adapter<BinViewHolder> {
    private ArrayList<Bin> mBins = new ArrayList<>();
    private Context mContext;

    public BinListAdapter(Context context, ArrayList<Bin> bins) {
        mContext = context;
        mBins = bins;
    }

    @Override
    public BinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_my_bin, parent, false);

        BinViewHolder viewHolder = new BinViewHolder(view, mBins);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BinViewHolder holder, int position) {
        holder.bindBin(mBins.get(position));
    }

    @Override
    public int getItemCount() {
        return mBins.size();
    }
}
