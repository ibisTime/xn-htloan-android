package com.cdkj.huatuweitong.tencent.logininterface;

/**
 * Created by cdkj on 2018/6/14.
 */

public interface TencentLoginInterface {

    // 更新登录状态
    void updateLoginState(boolean state);

    // 登录成功
    void onLoginSDKSuccess();

    // 登录失败
    void onLoginSDKFailed(String module, int errCode, String errMsg);

}
