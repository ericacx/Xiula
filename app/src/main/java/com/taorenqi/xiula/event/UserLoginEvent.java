/*
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:UserLoginEvent.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 */

package com.taorenqi.xiula.event;

/**
 * Created by lirichen on 2016/9/23.
 */

public class UserLoginEvent {
    private boolean isLoginSuccess;

    public UserLoginEvent(boolean isLoginSuccess) {
        this.isLoginSuccess = isLoginSuccess;
    }
}
