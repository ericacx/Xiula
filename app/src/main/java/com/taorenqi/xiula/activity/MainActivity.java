package com.taorenqi.xiula.activity;

import android.os.Bundle;

import com.taorenqi.xiula.R;
import com.taorenqi.xiula.activity.base.BaseActivity;
import com.taorenqi.xiula.app.XiulaApp;
import com.taorenqi.xiula.common.fragmentation.anim.DefaultHorizontalAnimator;
import com.taorenqi.xiula.common.fragmentation.anim.FragmentAnimator;
import com.taorenqi.xiula.fragment.MainContentFragment;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_frame,MainContentFragment.newInstance())
                    .commitAllowingStateLoss()
            ;

        }

    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

}
