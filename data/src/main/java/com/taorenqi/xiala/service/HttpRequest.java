package com.taorenqi.xiala.service;

import android.content.Context;

import com.taorenqi.xiala.common.ApiException;
import com.taorenqi.xiala.common.BaseResponse;
import com.taorenqi.xiala.executor.JobExecutor;
import com.taorenqi.xiala.executor.PostExecutionThread;
import com.taorenqi.xiala.executor.ThreadExecutor;
import com.taorenqi.xiala.executor.UIThread;
import com.taorenqi.xiala.interceptor.HeaderInterceptor;
import com.taorenqi.xiala.interceptor.LoggingInterceptor;
import com.taorenqi.xiala.interceptor.NetworkStatusInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017-06-08.
 */

public class HttpRequest {

    public static final String BASE_URL = "http://test.www.dongchajia.com/";
    //        public static final String BASE_URL = "http://m.dongchajia.com/";
//    public static final String BASE_URL = "https://api.dongchajia.com/";
    public static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_TIMEOUT = 300;
    private final long SIZE_OF_CACHE = 20 * 1024 * 1024; // 20 MiB

    protected Retrofit retrofit;
    protected Context mContext;
    ThreadExecutor threadExecutor = new JobExecutor(); //子线程
    PostExecutionThread postExecutionThread = new UIThread(); //主线程（UI线程）

    //构造方法私有
    protected HttpRequest(Context context) {

        Cache cache = new Cache(new File(context.getCacheDir(), "ok-http-cache"), SIZE_OF_CACHE);
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new NetworkStatusInterceptor(context));
        builder.addNetworkInterceptor(new LoggingInterceptor());
//        builder.addInterceptor(new ParameterInterceptor());
        builder.addInterceptor(new HeaderInterceptor(context));
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.cache(cache);
        mContext = context;

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }


    protected <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(s);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    protected class HttpResultFunc<T> implements Func1<BaseResponse<T>, T> {

        @Override
        public T call(BaseResponse<T> response) {

            if (response.getCode() == 200) {
                return response.getData();
            } else if (response.getCode() == 100) {
                return response.getData();
            } else if (response.getCode() == 101) {
                return response.getData();
            } else if (response.getCode() == 102) {
                return response.getData();
            }
            throw new ApiException(response.getCode());
        }
    }
}
