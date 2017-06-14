/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:OnTabReselectListener.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiula.common.widget.bottombar;

import android.support.annotation.IdRes;

public interface OnTabReselectListener {
    /**
     * The method being called when currently visible {@link BottomBarTab} is
     * reselected. Use this method for scrolling to the top of your content,
     * as recommended by the Material Design spec
     *
     * @param tabId the {@link BottomBarTab} that was reselected.
     */
    void onTabReSelected(@IdRes int tabId);
}
