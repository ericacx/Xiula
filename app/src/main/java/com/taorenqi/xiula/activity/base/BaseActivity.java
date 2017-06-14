/*
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:BaseActivity.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 */

package com.taorenqi.xiula.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.taorenqi.xiula.common.fragmentation.SupportActivity;
import com.umeng.analytics.MobclickAgent;

/**
 * 作者：lirichen
 * 主要功能:页面公用管理
 * 创建时间：2016/09/11 12:46
 */
public class BaseActivity extends SupportActivity {

    public final String TAG = "XIULA";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
