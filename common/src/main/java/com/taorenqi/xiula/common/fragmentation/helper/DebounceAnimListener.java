/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:DebounceAnimListener.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiula.common.fragmentation.helper;

import android.view.animation.Animation;

import com.taorenqi.xiula.common.fragmentation.SupportFragment;

/**
 * 转场动画监听器: 主要是为了监听入场动画
 * Created by YoKeyword on 16/6/23.
 */
public class DebounceAnimListener implements Animation.AnimationListener {
    private SupportFragment fragment;

    public DebounceAnimListener(SupportFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        fragment.notifyEnterAnimEnd();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
