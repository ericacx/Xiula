/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:NetworkStatusInterceptor.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiala.interceptor;

import android.content.Context;

import com.taorenqi.xiala.executor.NetworkConnectionException;
import com.taorenqi.xiala.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lirichen on 2016/11/25.
 */

public class NetworkStatusInterceptor implements Interceptor {

    private Context context;

    public NetworkStatusInterceptor(Context context) {
        this.context = context;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (NetworkUtils.isAvailable(context) && NetworkUtils.isConnected(context)) {
            return chain.proceed(chain.request());
        } else {
            throw new NetworkConnectionException();
        }
    }

}
