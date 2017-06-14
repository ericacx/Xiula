/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:BadgeCircle.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiula.common.widget.bottombar;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

class BadgeCircle {
    /**
     * Creates a new circle for the Badge background.
     *
     * @param size  the width and height for the circle
     * @param color the activeIconColor for the circle
     * @return a nice and adorable circle.
     */
    static ShapeDrawable make(int size, int color) {
        ShapeDrawable indicator = new ShapeDrawable(new OvalShape());
        indicator.setIntrinsicWidth(size);
        indicator.setIntrinsicHeight(size);
        indicator.getPaint().setColor(color);
        return indicator;
    }
}
