/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:BaseShareFragment.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiula.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
//
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tripint.intersight.activity.MainActivity;
//import com.tripint.intersight.activity.base.BaseActivity;
//import com.tripint.intersight.app.InterSightApp;
//import com.tripint.intersight.entity.ShareLoginEntity;
//import com.tripint.intersight.helper.CommonUtils;
//import com.tripint.intersight.model.LinkedinResponeModel;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lirichen on 2016/11/24.
 */
//public abstract class BaseShareFragment extends BaseBackFragment {

//    private MainActivity mContext;
//
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getActivity() instanceof BaseActivity) {
//            mContext = (MainActivity) getActivity();
//        }
//    }
//
//    protected abstract void shareLoginSuccess(SHARE_MEDIA platform, ShareLoginEntity entity);
//
//    protected void sharedLogin(final SHARE_MEDIA platform) {
//
////        showProgressDialog();
//        mContext.mShareAPI.doOauthVerify(mContext, platform, new UMAuthListener() {
//            @Override
//            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
////                mContext.showProgress("正在验证授权信息……");
//
//                for (Map.Entry<String, String> entry : map.entrySet()) {
//                    if ("access_token".equals(entry.getKey())) {
////                        params.put(entry.getKey(), entry.getValue());
//                    }
//                    if ("uid".equals(entry.getKey())) {
////                        params.put(entry.getKey(), entry.getValue());
//                    }
//                    if ("screen_name".equals(entry.getKey())) {
////                        params.put(entry.getKey(), entry.getValue());
//                    }
//                    if ("version".equals(entry.getKey())) {
////                        params.put(entry.getKey(), entry.getValue());
//                    }
//                }
////                params.put("version", "1");
////                MLog.d("授权第一步=" + params.toString());
//                mContext.mShareAPI.getPlatformInfo(mContext, platform, new UMAuthListener() {
//                    @Override
//                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
//                        if (null != map) {
//                            dismissProgressDialog();
//                            ShareLoginEntity model = new ShareLoginEntity(ShareLoginEntity.SHARE_TYPE_WEIXIN);
//                            for (Map.Entry<String, String> entry : map.entrySet()) {
////                                params.put(entry.getKey(), entry.getValue());
//                                if ("access_token".equals(entry.getKey())) {
////                                    params.put(entry.getKey(), entry.getValue());
//                                }
//                                if ("screen_name".equals(entry.getKey())) {
////                                    params.put(entry.getKey(), entry.getValue());
//                                    model.setNickName(entry.getValue());
//                                }
//                                if ("profile_image_url".equals(entry.getKey())) {
////                                    params.put(entry.getKey(), entry.getValue());
//                                    model.setImgUrl(entry.getValue());
//                                }
//                                if (share_media == SHARE_MEDIA.WEIXIN) {
//                                    if (entry.getKey().equals("openid")) {
//                                        model.setOpenId(entry.getValue());
//                                    }
//                                    if (entry.getKey().equals("unionid")) {
//                                        model.setUnionId(entry.getValue());
//                                    }
//                                } else {
//                                    if ("uid".equals(entry.getKey())) {
////                                        params.put(entry.getKey(), entry.getValue());
//                                    }
//                                }
//                            }
////                            MLog.d("授权第二步=" + params.toString());
////                            submitLoginInfo(url, params, flag, media);
////                            shareLoginModel = model;
//                            shareLoginSuccess(SHARE_MEDIA.WEIXIN, model);
////                            start(LongBindPhoneFragment.newInstance(model));
//
//                        } else {
//                            CommonUtils.showToast("授权失败");
////                            mContext.dismissProgressDialog();
//                            dismissProgressDialog();
//                        }
//                    }
//
//                    @Override
//                    public void onError(SHARE_MEDIA share_media, int i, Throwable e) {
////                        mContext.dismissProgressDialog();
//                        dismissProgressDialog();
//                        CommonUtils.showToast("授权失败");
//                    }
//
//                    @Override
//                    public void onCancel(SHARE_MEDIA share_media, int i) {
////                        mContext.dismissProgressDialog();
//                        dismissProgressDialog();
//                        CommonUtils.showToast("授权失败");
//                    }
//                });
//            }
//
//            @Override
//            public void onError(SHARE_MEDIA share_media, int i, Throwable e) {
////                mContext.dismissProgressDialog();
////                mContext.httpError(e);
//                dismissProgressDialog();
//
//                CommonUtils.showToast("授权失败");
//            }
//
//            @Override
//            public void onCancel(SHARE_MEDIA share_media, int i) {
////                mContext.dismissProgressDialog();
//                dismissProgressDialog();
//
//                CommonUtils.showToast("授权失败");
//            }
//
//        });
//
//    }
//
//    protected void sharedLinkedInLogin() {
//        showProgressDialog();
//
//        LISessionManager.getInstance(mActivity).init(mActivity, InterSightApp.getApp().buildScope(), new AuthListener() {
//            @Override
//            public void onAuthSuccess() {
//                dismissProgressDialog();
//                setUpdateState();
//                String token = LISessionManager.getInstance(mActivity).getSession().getAccessToken().getValue();
//
//                String url = "https://api.linkedin.com/v1/people/~";
//
//                APIHelper apiHelper = APIHelper.getInstance(mActivity);
//                apiHelper.getRequest(mActivity, url, new ApiListener() {
//                    @Override
//                    public void onApiSuccess(ApiResponse apiResponse) {
//                        // Success!
//                        try {
//
//
//                            ObjectMapper mapper = new ObjectMapper();
//                            LinkedinResponeModel obj = mapper.readValue(apiResponse.getResponseDataAsString(), LinkedinResponeModel.class);
//                            ShareLoginEntity model = new ShareLoginEntity(ShareLoginEntity.SHARE_TYPE_LINKEDIN);
//                            model.setUnionId(obj.getId());
//                            model.setOpenId(obj.getId());
//                            model.setNickName(obj.getFirstName());
//                            model.setImgUrl(obj.getSiteStandardProfileRequest() != null ? obj.getSiteStandardProfileRequest().getUrl() : "");
////                            shareLoginModel = model;
//                            shareLoginSuccess(SHARE_MEDIA.LINKEDIN, model);
//
//                        } catch (JsonGenerationException e) {
//                            Log.d("TAG", e.getLocalizedMessage());
//                        } catch (JsonMappingException e) {
//                            Log.d("TAG", e.getLocalizedMessage());
//                        } catch (IOException e) {
//                            Log.d("TAG", e.getLocalizedMessage());
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onApiError(LIApiError liApiError) {
//                        // Error making GET request!
//                    }
//                });
//            }
//
//            @Override
//            public void onAuthError(LIAuthError error) {
//                dismissProgressDialog();
//                setUpdateState();
//                CommonUtils.showToast("授权失败");
////                Toast.makeText(InterSightApp.getApp().getApplicationContext(), "failed " + error.toString(), Toast.LENGTH_LONG).show();
//            }
//        }, true);
//    }
//
//    private void setUpdateState() {
//        LISessionManager sessionManager = LISessionManager.getInstance(mActivity);
//        LISession session = sessionManager.getSession();
//        boolean accessTokenValid = session.isValid();
//
//    }
//}
