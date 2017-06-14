/*
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:HeaderInterceptor.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 */

package com.taorenqi.xiala.interceptor;

import android.content.Context;

import com.taorenqi.xiala.utils.StringUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lirichen on 16/9/12.
 */
public class HeaderInterceptor implements Interceptor {

    private Context context;

    public HeaderInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        String token = "";
        if (StringUtils.isEmpty(token)) {
            token = "";
        }
        Request request = original.newBuilder()
                .header("Token", token)
                .header("Client", "App/V1")
                .header("Terminal","1")
                .method(original.method(), original.body())
                .build();

        return chain.proceed(request);

    }
}
