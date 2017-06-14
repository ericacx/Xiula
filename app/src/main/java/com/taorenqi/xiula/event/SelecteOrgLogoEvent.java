/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:SelecteOrgLogoEvent.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiula.event;

/**
 * Created by lirichen on 2016/9/23.
 */

public class SelecteOrgLogoEvent {
    public String name;
    public String logo;
    public int flg;

    public SelecteOrgLogoEvent(String name, String logo, int flg) {
        this.name = name;
        this.logo = logo;
        this.flg = flg;
    }


}
