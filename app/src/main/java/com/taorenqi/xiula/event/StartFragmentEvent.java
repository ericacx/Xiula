/*
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:StartFragmentEvent.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 */

package com.taorenqi.xiula.event;


import com.taorenqi.xiula.common.fragmentation.SupportFragment;

/**
 * Created by YoKeyword on 16/6/30.
 */
public class StartFragmentEvent {
    public SupportFragment targetFragment;

    public StartFragmentEvent(SupportFragment targetFragment) {
        this.targetFragment = targetFragment;
    }
}
