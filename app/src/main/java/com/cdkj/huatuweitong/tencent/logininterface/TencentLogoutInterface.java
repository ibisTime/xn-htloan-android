package com.cdkj.huatuweitong.tencent.logininterface;

/**
 * Created by cdkj on 2018/6/14.
 */

public interface TencentLogoutInterface {

    void emptyLoginUser();

    // 登出成功
    void onLogoutSDKSuccess();

    // 登出失败
    void onLogoutSDKFailed(String module, int errCode, String errMsg);
}
