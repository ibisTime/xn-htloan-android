package com.cdkj.huatuweitong;

import android.app.Application;
import android.content.Context;

import com.cdkj.baselibrary.CdApplication;

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
    }

    public static Context getInstance() {
        return instance;
    }
}
