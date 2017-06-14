/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:CachingControlInterceptor.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiala.interceptor;

import android.content.Context;

import com.taorenqi.xiala.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lirichen on 2016/11/25.
 */

public class CachingControlInterceptor implements Interceptor {

    private Context context;

    public CachingControlInterceptor(Context context) {
        this.context = context;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // Add Cache Control only for GET methods
        if (request.method().equals("GET")) {
            if (NetworkUtils.isAvailable(context)) {
                // 1 min
                int maxAge = 10;
                request = request.newBuilder()
//                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 2; // tolerate 4-weeks stale
                request = request.newBuilder()
                        .header("Cache-Control", "public, max-stale=" + maxStale)
                        .build();
            }
        }

        Response originalResponse = chain.proceed(request);
        return originalResponse.newBuilder()
                .header("Cache-Control", "max-age=600")
                .build();
    }

}
