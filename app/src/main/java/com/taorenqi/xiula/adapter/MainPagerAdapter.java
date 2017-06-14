package com.taorenqi.xiula.adapter;




import android.support.v4.app.FragmentManager;

import com.taorenqi.xiula.common.fragmentation.SupportFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-06-09.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<SupportFragment> fragments;

    public MainPagerAdapter(FragmentManager fm, ArrayList<SupportFragment> fragments) {
        super(fm);
        if (fragments == null) {
            throw new IllegalArgumentException("fragments不能为空");
        }
        this.fragments = fragments;
    }

    @Override
    public SupportFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}