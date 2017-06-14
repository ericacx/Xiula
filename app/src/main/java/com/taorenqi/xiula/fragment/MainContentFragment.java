package com.taorenqi.xiula.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.taorenqi.xiula.R;
import com.taorenqi.xiula.common.fragmentation.SwipeBackFragment;
import com.taorenqi.xiula.common.fragmentation.anim.FragmentAnimator;
import com.taorenqi.xiula.entity.TabEntity;
import com.taorenqi.xiula.event.StartFragmentEvent;
import com.taorenqi.xiula.event.StartFragmentForResultEvent;
import com.taorenqi.xiula.event.TabSelectedEvent;
import com.taorenqi.xiula.event.UserLoginEvent;
import com.taorenqi.xiula.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * .
 */
public class MainContentFragment extends SwipeBackFragment {

    private ViewPager mViewPager;
    private CommonTabLayout mCommonTabLayout;

    private List<SwipeBackFragment> mFragments = new ArrayList<>();

    private String[] mTitles = {"首页", "试用", "进度", "我的"};
    private int[] mIconUnselectIds = {
            R.drawable.tab_home_unselect, R.drawable.tab_speech_unselect,
            R.drawable.tab_contact_unselect, R.drawable.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.drawable.tab_home_select, R.drawable.tab_speech_select,
            R.drawable.tab_contact_select, R.drawable.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    public static MainContentFragment newInstance() {

        Bundle args = new Bundle();

        MainContentFragment fragment = new MainContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_content, container, false);
        initTabLayout(view);
        return view;
    }

    private void initTabLayout(View view) {
        mViewPager = ((ViewPager) view.findViewById(R.id.main_container));
        mCommonTabLayout = ((CommonTabLayout) view.findViewById(R.id.commonTabLayout));
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mCommonTabLayout.setTabData(mTabEntities);


        mFragments.add(HomeFragment.newInstance());
        mFragments.add(FreeFragment.newInstance());
        mFragments.add(ProgressFragment.newInstance());
        mFragments.add(MineFragment.newInstance());


        mCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });


        mViewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCommonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }


    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return super.onCreateFragmentAnimator();
    }

    @Subscribe
    public void onEvent(TabSelectedEvent event) {/* Do something */}


    @Subscribe
    public void startFragment(StartFragmentEvent event) {
        start(event.targetFragment);
    }


    @Subscribe
    public void startLoginFragment(StartFragmentForResultEvent event) {
        startForResult(event.targetFragment, event.requestCode);
    }

    @Override
    protected void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (requestCode == StartFragmentForResultEvent.REQ_LOGIN_FRAGMENT && resultCode == RESULT_OK) {
            CommonUtils.showToast("登录成功");
            EventBus.getDefault().post(new UserLoginEvent(true));
        }
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
