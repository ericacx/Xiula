/*
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:StartFragmentForResultEvent.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 */

package com.taorenqi.xiula.event;


import com.taorenqi.xiula.common.fragmentation.SupportFragment;

/**
 * Created by lirichen on 16/6/30.
 */
public class StartFragmentForResultEvent {

    public static final int REQ_LOGIN_FRAGMENT = 100;

    public SupportFragment targetFragment;
    public int requestCode;

    public StartFragmentForResultEvent(SupportFragment targetFragment, int requestCode) {
        this.targetFragment = targetFragment;
        this.requestCode = requestCode;
    }
}
