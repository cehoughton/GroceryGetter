package com.epicodus.grocerygetter.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.Bin;
import com.epicodus.grocerygetter.ui.BinDetailActivity;
import com.epicodus.grocerygetter.ui.MyBinListActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class BinViewHolder extends RecyclerView.ViewHolder {
//   private static final int MAX_WIDTH = 200;
//   private static final int MAX_HEIGHT = 200;

    @Bind(R.id.binSizeTextView) TextView mBinSizeTextView;
    @Bind(R.id.binContentTextView) TextView mBinContentTextView;

    private Context mContext;
    private ArrayList<Bin> mBins = new ArrayList<>();

    public BinViewHolder(View itemView, ArrayList<Bin> bins) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mContext = itemView.getContext();
        mBins = bins;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, BinDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("bins", Parcels.wrap(mBins));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindBin(Bin bin) {

        mBinSizeTextView.setText(bin.getSize());
        String contents = TextUtils.join(", ", bin.getContents());
        mBinContentTextView.setText(contents);
    }
}
