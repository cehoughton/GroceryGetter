package com.epicodus.grocerygetter.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.grocerygetter.R;
import com.epicodus.grocerygetter.models.Bin;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BinDetailFragment extends Fragment {
    @Bind(R.id.binSizeTextView)
    TextView mBinSizeLabel;
    @Bind(R.id.binContentTextView) TextView mBinContentLabel;
    @Bind(R.id.saveBinButton) TextView mSaveBinButton;

    private Bin mBin;

    public static BinDetailFragment newInstance(Bin bin) {
        BinDetailFragment binDetailFragment = new BinDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("bin", Parcels.wrap(bin));
        binDetailFragment.setArguments(args);
        return binDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBin = Parcels.unwrap(getArguments().getParcelable("bin"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bin_detail, container, false);
        ButterKnife.bind(this, view);

        mBinSizeLabel.setText(mBin.getSize());
        mBinContentLabel.setText(android.text.TextUtils.join(", ", mBin.getContents()));
        return view;
    }

}




