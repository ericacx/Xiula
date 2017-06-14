/*******************************************************************************
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:BaseFragment.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 ******************************************************************************/

package com.taorenqi.xiula.fragment.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

//import com.taorenqi.xiula.R;
//import com.taorenqi.xiula.app.InterSightApp;
//import com.taorenqi.xiula.common.Constants;
//import com.taorenqi.xiula.common.fragmentation.SwipeBackFragment;
//import com.taorenqi.xiula.common.widget.filter.util.CommonUtil;
//import com.taorenqi.xiula.helper.ProgressDialogUtils;


/**
 * Created by YoKeyword on 16/2/3.
 */
//public class BaseFragment extends SwipeBackFragment {

//    private String shareTitle;
//    private String shareLink;
//    private String shareImageUrl;
//
//    private UMShareListener umShareListener = new UMShareListener() {
//        @Override
//        public void onResult(SHARE_MEDIA platform) {
//            Log.d("plat", "platform" + platform);
//
//            Toast.makeText(mActivity, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
//
//        }
//
//        @Override
//        public void onError(SHARE_MEDIA platform, Throwable t) {
//            Toast.makeText(mActivity, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
//            if (t != null) {
//                Log.d("throw", "throw:" + t.getMessage());
//            }
//        }
//
//        @Override
//        public void onCancel(SHARE_MEDIA platform) {
//            Toast.makeText(mActivity, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
//        }
//    };
//
//    private ShareBoardlistener shareBoardlistener = new ShareBoardlistener() {
//
//        @Override
//        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
//            if (share_media == null) {
//                if (snsPlatform.mKeyword.equals("umeng_socialize_text_linkedin_key")) {
//                    LISessionManager.getInstance(mActivity).init(mActivity, InterSightApp.getApp().buildScope(), new AuthListener() {
//                        @Override
//                        public void onAuthSuccess() {
//                            // Authentication was successful.  You can now do
//                            // other calls with the SDK.
//                            String url = "https://api.linkedin.com/v1/people/~/shares";
//
//                            String payload = "{" +
//                                    "\"comment\":\"" + shareTitle +
//                                    shareLink + "\"," +
//                                    "\"visibility\":{" +
//                                    "    \"code\":\"anyone\"}" +
//                                    "}";
//
//                            APIHelper apiHelper = APIHelper.getInstance(mActivity);
//                            apiHelper.postRequest(mActivity, url, payload, new ApiListener() {
//                                @Override
//                                public void onApiSuccess(ApiResponse apiResponse) {
//                                    // Success!
//                                    Toast.makeText(mActivity, " 分享成功啦", Toast.LENGTH_SHORT).show();
//
//                                }
//
//                                @Override
//                                public void onApiError(LIApiError liApiError) {
//                                    // Error making POST request!
//                                    Toast.makeText(mActivity, " 分享失败啦", Toast.LENGTH_SHORT).show();
//
//                                }
//                            });
//                        }
//
//                        @Override
//                        public void onAuthError(LIAuthError error) {
//                            // Handle authentication errors
//                            Toast.makeText(mActivity, " 分享失败啦", Toast.LENGTH_SHORT).show();
//                        }
//                    }, true);
//                }
//
//            } else {
//                ShareAction shareAction = getShareAction(shareTitle, shareLink, shareImageUrl);
//                shareAction.setPlatform(share_media).setCallback(umShareListener)
//                        .share();
//            }
//        }
//    };
//
//    protected void initToolbarShareMenu(Toolbar toolbar, final String shareTitle, final String shareLink, final String shareImageUrl) {
//        this.shareTitle = shareTitle;
//        this.shareLink = shareLink;
//        this.shareImageUrl = shareImageUrl;
//        if(toolbar.getMenu().size()<=0) {
//            toolbar.inflateMenu(R.menu.share);
//            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//                @Override
//                public boolean onMenuItemClick(MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.action_socialize_share:
////                        EventBus.getDefault().post(new StartFragmentEvent(NewMessageFragment.newInstance()));
//
//                            ShareAction shareAction = getShareAction(shareTitle, shareLink, shareImageUrl);
//
//                            shareAction.setDisplayList(
////                                    SHARE_MEDIA.SINA,
////                                    SHARE_MEDIA.QQ,
//                                    SHARE_MEDIA.WEIXIN,
//                                    SHARE_MEDIA.WEIXIN_CIRCLE,
////                                    SHARE_MEDIA.LINKEDIN,
////                                    SHARE_MEDIA.FACEBOOK,
////                                    SHARE_MEDIA.TWITTER,
////                                    SHARE_MEDIA.PINTEREST,
//                                    SHARE_MEDIA.SMS,
//                                    SHARE_MEDIA.EMAIL)
//                                    .addButton("umeng_socialize_text_linkedin_key", "umeng_socialize_text_linkedin_key", "umeng_socialize_linkedin", "umeng_socialize_linkedin")
//                                    .setShareboardclickCallback(shareBoardlistener)
//                                    .setCallback(umShareListener).open();
//                            break;
//                    }
//                    return true;
//                }
//            });
//        }
//    }
//
//    @NonNull
//    private ShareAction getShareAction(String shareTitle, String shareLink, String shareImageUrl) {
//        ShareAction shareAction = new ShareAction(mActivity).withTitle(shareTitle)
//                .withText(shareTitle)
//                .withTargetUrl(shareLink);
//        if (!CommonUtil.isEmpty(shareImageUrl)) {
//            UMImage image = new UMImage(mActivity, shareImageUrl);//网络图片
//            shareAction.withMedia(image);
//        } else {
//            UMImage image = new UMImage(mActivity, R.mipmap.ic_launcher);//网络图片
//            shareAction.withMedia(image);
//        }
//        return shareAction;
//    }
//
//    protected void initToolbarDebugMenu(Toolbar toolbar) {
//        toolbar.inflateMenu(R.menu.home);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_message:
//                        mActivity.showFragmentStackHierarchyView();
//                        mActivity.logFragmentStackHierarchy(Constants.TAG);
//                        break;
//                }
//                return true;
//            }
//        });
//    }
//
//    protected void showProgressDialog(){
//        ProgressDialogUtils.getInstants(mActivity).show();
//    }
//
//    protected void dismissProgressDialog(){
//        ProgressDialogUtils.getInstants(mActivity).dismiss();
//    }

//}
