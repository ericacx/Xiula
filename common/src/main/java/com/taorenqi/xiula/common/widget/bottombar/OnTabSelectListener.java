/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:OnTabSelectListener.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiula.common.widget.bottombar;

import android.support.annotation.IdRes;

public interface OnTabSelectListener {
    /**
     * The method being called when currently visible {@link BottomBarTab} changes.
     *
     * This listener is fired for the first time after the items have been set and
     * also after a configuration change, such as when screen orientation changes
     * from portrait to landscape.
     *
     * @param tabId the new visible {@link BottomBarTab}
     */
    void onTabSelected(@IdRes int tabId);
}
