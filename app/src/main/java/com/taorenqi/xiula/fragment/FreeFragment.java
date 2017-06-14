package com.taorenqi.xiula.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taorenqi.xiula.R;
import com.taorenqi.xiula.common.fragmentation.SwipeBackFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FreeFragment extends SwipeBackFragment {


    public static FreeFragment newInstance() {
        // Required empty public constructor
        Bundle args = new Bundle();
        FreeFragment fragment = new FreeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_free, container, false);
        return view;
    }

}
