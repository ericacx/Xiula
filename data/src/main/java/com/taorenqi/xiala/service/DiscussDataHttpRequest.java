package com.taorenqi.xiala.service;

import android.content.Context;

import com.taorenqi.xiala.common.BasePageableResponse;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2017-06-12.
 */

public class DiscussDataHttpRequest extends HttpRequest{

    private static DiscussDataHttpRequest instants;
    private DiscussDataService service;

    private DiscussDataHttpRequest(Context context) {
        super(context);
        service = retrofit.create(DiscussDataService.class);
    }

    public static DiscussDataHttpRequest getInstance(Context context){
        if (instants == null){
            instants = new DiscussDataHttpRequest(context);
        }

        return instants;
    }


    /**
     * 用于取得行业数据
     *
     * @param subscriber 由调用者传过来的观察者对象
     * @param start      起始位置
     * @param count      获取长度
     */
    public void getDiscusses(Subscriber<BasePageableResponse<String>> subscriber, int start, int count) {

        Observable observable = service.getDiscuss(start, DEFAULT_PAGE_SIZE)
                .map(new HttpResultFunc<BasePageableResponse<String>>());


        toSubscribe(observable, subscriber);
    }
}
