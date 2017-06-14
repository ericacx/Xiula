package com.taorenqi.xiula.app;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.squareup.leakcanary.LeakCanary;
import com.taorenqi.xiula.helper.PermissionsChecker;
import com.taorenqi.xiula.utils.CommonUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.task.LocalImageLoader;

import java.util.Locale;

/**
 * Created by Administrator on 2017-06-08.
 */

public class XiulaApp extends Application {

    private static XiulaApp app;
    public final int REQUEST_CODE = 911; // 请求码

    // 文件权限
    public final String[] PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,  //允许程序写入外部存储
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS, //挂载、反挂载外部文件系统
            Manifest.permission.READ_LOGS, //读取系统底层日志
            Manifest.permission.WRITE_SETTINGS, //允许读写系统设置项
    };
    //获取位置权限
    public final String[] LOCATIONS = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    //获取联系人权限
    public final String[] CONTACTS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,  //允许程序写入外部存储
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_CONTACTS //允许应用访问联系人通讯录信息
    };
    //获取联系人权限
    public final String[] FILE_CAMERA = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,  //允许程序写入外部存储
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA //允许应用访问联系人通讯录信息
    };

    //允许程序写入外部存储
    public final String[] FILE = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,  //允许程序写入外部存储
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };
    //获取摄像头权限
    public final String[] CAMERA = new String[]{
            Manifest.permission.CAMERA //允许访问摄像头进行拍照
    };
    //获取摄像头权限
    public final String[] RECORD_AUDIO = new String[]{
            Manifest.permission.RECORD_AUDIO //允许访问mic
    };
    //获取拨打电话权限
    public final String[] PHONE = new String[]{
            Manifest.permission.CALL_PHONE, //允许程序从非系统拨号器里输入电话号码
            Manifest.permission.READ_PHONE_STATE, //访问电话状态
            Manifest.permission.RECORD_AUDIO //允许访问mic
    };
    public PermissionsChecker mPermissionsChecker; // 权限检测器
    private boolean isUserLogin = false; //登陆为 true 未登陆为 false
    private boolean isBinding = false; //是否绑定第三方账号（第一次）

    public static XiulaApp getApp() {
        return app;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        init();
    }

    private void init() {

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        initUmengAgent();
        initBugly();

        initAlbum();
    }

    private void initAlbum() {
        Album.initialize(new AlbumConfig.Build()
                .setImageLoader(new LocalImageLoader())
                .setLocale(Locale.getDefault())
                .build()
        );
    }

    private void initUmengAgent() {

        //友盟统计
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.setCatchUncaughtExceptions(false);

    }

    private void initBugly() {
        //Bugly 异常统计
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        strategy.setAppChannel(CommonUtils.getUmengChannel());
        strategy.setAppReportDelay(60);
//        CrashReport.initCrashReport(getApplicationContext(), Constants.BUGLY_APP_ID, false);
        CrashReport.initCrashReport(getApplicationContext(), "", false);//bugly的id
    }

    /**
     * 权限检测器
     *
     * @return
     */
    public PermissionsChecker getPermissionsChecker() {
        if (null == mPermissionsChecker) {
            mPermissionsChecker = new PermissionsChecker(getApplicationContext());
        }
        return mPermissionsChecker;
    }
}
