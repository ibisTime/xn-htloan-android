package com.cdkj.huatuweitong.tencent;

import android.content.Context;
import android.text.TextUtils;

import com.cdkj.huatuweitong.tencent.logininterface.TencentLogoutInterface;
import com.tencent.ilivesdk.ILiveCallBack;
import com.tencent.ilivesdk.core.ILiveLoginManager;

/**
 * Created by lq on 2017/11/27.
 */

public class TencentLogoutHelper {

    private TencentLogoutInterface mListener;
    private Context mContext;

    public TencentLogoutHelper(TencentLogoutInterface view) {
        this.mListener = view;
    }

    //处理登出逻辑
    public void logout() {

        if (TextUtils.isEmpty(ILiveLoginManager.getInstance().getLoginUserSig())){
            mListener.emptyLoginUser();
        }else {
            //登出
            ILiveLoginManager.getInstance().iLiveLogout(new ILiveCallBack() {
                @Override
                public void onSuccess(Object data) {
                    mListener.onLogoutSDKSuccess();
                }

                @Override
                public void onError(String module, int errCode, String errMsg) {
                    mListener.onLogoutSDKFailed(module, errCode, errMsg);
                }
            });
        }

    }

    //处理持有对象
    public void clear() {
        this.mListener = null;
        this.mContext = null;
    }


}
