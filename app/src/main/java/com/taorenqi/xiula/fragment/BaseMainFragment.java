package com.taorenqi.xiula.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by Administrator on 2017-06-09.
 */

public abstract class BaseMainFragment extends Fragment {

    protected Context mContext;
    private View rootView;

    public static <T> BaseMainFragment newInstance(Context context, Class<?> clazz) {
        return newInstance(context, clazz, null);
    }

    public static <T> BaseMainFragment newInstance(Context context, Class<?> clazz, Bundle bundle) {
        if (clazz != null) {
            BaseMainFragment fragment = (BaseMainFragment) instantiate(context, clazz.getName());
            fragment.setArguments(bundle);
            return fragment;
        }
        return null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResId(), container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    /**
     * 返回布局ID
     *
     * @return
     */
    protected abstract int getLayoutResId();

    protected abstract void initDate();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}