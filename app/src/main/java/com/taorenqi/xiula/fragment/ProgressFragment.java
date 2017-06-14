package com.taorenqi.xiula.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taorenqi.xiula.R;
import com.taorenqi.xiula.common.fragmentation.SwipeBackFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgressFragment extends SwipeBackFragment {


    public static ProgressFragment newInstance() {
        // Required empty public constructor
        Bundle args = new Bundle();
        ProgressFragment fragment = new ProgressFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        return view;
    }

    //逻辑操作（网络请求）
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
