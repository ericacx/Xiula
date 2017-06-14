/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:DiscussDataService.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiala.service;


import com.taorenqi.xiala.common.BasePageableResponse;
import com.taorenqi.xiala.common.BaseResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lirichen on 16/9/12.
 */
public interface DiscussDataService {

    //观点
    @GET("discuss")
    Observable<BaseResponse<BasePageableResponse<String>>> getDiscuss(@Query("page") int page, @Query("size") int size);

    //观点
    @FormUrlEncoded
    @POST("discuss")
    Observable<BaseResponse<String>> createDiscuss(@Field("content") String content, @Field("industryId") int industryId, @Field("toUid") int toUid);

//    @GET("mine/discuss")
//    Observable<BaseResponse<BasePageableResponse<DiscussEntiry>>> getSearchFilter(@Query("type") String type);
//
//    @GET("discuss/{id}")
//    Observable<BaseResponse<DiscussDetailResponseEntity>> getDiscussDetail(@Path("id") int id);
//
//    @PUT("discuss/{id}")
//    Observable<BaseResponse<CommentResultEntity>> createComment(@Path("id") int id, @Query("action") String action, @Query("type") String type, @Query("content") String content);
//
//    @PUT("discuss/{id}")
//    Observable<BaseResponse<CommentResultEntity>> createSubComment(@Path("id") int id, @Query("action") String action,
//                                                                   @Query("type") String type,
//                                                                   @Query("content") String content,
//                                                                   @Query("commentId") int commentId,
//                                                                   @Query("toNickname") String toNickname);
//
//    @PUT("discuss/{id}")
//    Observable<BaseResponse<CommentResultEntity>> createPraises(@Path("id") int id, @Query("action") String action, @Query("type") String type);
//
//    @PUT("discuss/{id}")
//    Observable<BaseResponse<CommentResultEntity>> deletePraises(@Path("id") int id, @Query("action") String action, @Query("type") String type);
//
//    @PUT("discuss/{id}")
//    Observable<BaseResponse<CommentResultEntity>> createFollow(@Path("id") int id, @Query("action") String action, @Query("type") String type);
//
//    @PUT("discuss/{id}")
//    Observable<BaseResponse<CommentResultEntity>> deleteFollow(@Path("id") int id, @Query("action") String action, @Query("type") String type);
//
//    //找人
//    @GET("interview")
//    Observable<BaseResponse<BasePageableResponse<InterviewEntity>>> getInterview(@Query("page") int page,
//                                                                                 @Query("size") int size,
//                                                                                 @Query("keyword") String keyword,
//                                                                                 @Query("industryId") String industry,
//                                                                                 @Query("abilityId") String position,
//                                                                                 @Query("company") String company);
//
//    //找文章
//    @GET("search/article")
//    Observable<BaseResponse<BasePageableResponse<SearchArticleEntity>>> getSearchArticles(@Query("page") int page, @Query("size") int size,
//                                                                                          @Query("keyword") String keyword,
//                                                                                          @Query("industryId") String industry,
//                                                                                          @Query("abilityId") String ability,
//                                                                                          @Query("orderBy") String orderBy);
}
