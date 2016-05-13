package com.epicodus.grocerygetter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.Bin;
import com.epicodus.grocerygetter.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/12/16.
 */
public class FirebaseBinListAdapter extends FirebaseRecyclerAdapter<BinViewHolder, Bin> {

    public FirebaseBinListAdapter(Query query, Class<Bin> itemClass) {
        super(query, itemClass);
    }

    @Override
    public BinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_bin_list, parent, false);
        return new BinViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(BinViewHolder holder, int position) {
        holder.bindBin(getItem(position));
    }

    @Override
    protected void itemAdded(Bin item, String key, int position) {

    }

    @Override
    protected void itemChanged(Bin oldItem, Bin newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Bin item, String key, int position) {

    }

    @Override
    protected void itemMoved(Bin item, String key, int oldPosition, int newPosition) {

    }
}
