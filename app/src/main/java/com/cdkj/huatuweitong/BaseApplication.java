package com.cdkj.huatuweitong;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.cdkj.baselibrary.CdApplication;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.ilivesdk.ILiveSDK;
import com.tencent.ilivesdk.core.ILiveRoomConfig;
import com.tencent.ilivesdk.core.ILiveRoomManager;
import com.tencent.qalsdk.sdk.MsfSdkUtils;

/**
 * Created by cdkj on 2018/1/31.
 */

public class BaseApplication extends Application {

    public static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        CdApplication.initialize(this, true);

        initXinGePush();
        initTencentILive();
    }

    private void initTencentILive() {
        // 判断仅在主线程进行初始化
        if (MsfSdkUtils.isMainProcess(this)) {
            // 初始化iLiveSDK
            ILiveSDK.getInstance().initSdk(this, MyCdConfig.SDKAPP_ID, MyCdConfig.ACCOUNT_TYPE);
            // 初始化iLiveSDK房间管理模块
            ILiveRoomManager.getInstance().init(new ILiveRoomConfig());
        }
    }

    private void initXinGePush(){
        XGPushConfig.enableDebug(this,true);

        XGPushConfig.enableOtherPush(getApplicationContext(), true);
        XGPushConfig.setHuaweiDebug(true);
        XGPushConfig.setMiPushAppId(getApplicationContext(), "acb628db7ebe7");
        XGPushConfig.setMiPushAppKey(getApplicationContext(), "c8cb48f5114611a9128d01afaf6ec316");
        XGPushConfig.setMzPushAppId(this, "acb628db7ebe7");
        XGPushConfig.setMzPushAppKey(this, "c8cb48f5114611a9128d01afaf6ec316");
    }

    public static Context getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
