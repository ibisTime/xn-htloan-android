package com.cdkj.huatuweitong.tencent;

import android.content.Context;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.TencentSignModel;
import com.cdkj.huatuweitong.tencent.logininterface.TencentLoginInterface;
import com.tencent.ilivesdk.ILiveCallBack;
import com.tencent.ilivesdk.core.ILiveLoginManager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * Created by cdkj on 2018/6/14.
 */

public class TencentLoginHelper implements ILiveLoginManager.TILVBStatusListener {

    private Context context;
    private TencentLoginInterface loginInterface;

    public TencentLoginHelper(Context context, TencentLoginInterface loginInterface) {
        this.context = context;
        this.loginInterface = loginInterface;
    }


    /**
     * 获取腾讯签名
     */
    public void login() {
        if (context == null) {  //没有登录
            return;
        }

        if (!SPUtilHelper.isLoginNoStart()) {  //没有登录
            return;
        }
//        loginTencent(MyCdConfig.User_Sig);
        Map map = new HashMap<>();

        map.put("userId", SPUtilHelper.getUserId());
        map.put("token", SPUtilHelper.getUserToken());
        map.put("systemCode", MyCdConfig.SYSTEM_CODE);
        map.put("companyCode", MyCdConfig.COMPANY_CODE);

        Call<BaseResponseModel<TencentSignModel>> call = RetrofitUtils.createApi(MyApiServer.class).getTencentSign("630800", StringUtils.getJsonToString(map));

        call.enqueue(new BaseResponseModelCallBack<TencentSignModel>(context) {
            @Override
            protected void onSuccess(TencentSignModel data, String SucMessage) {

                loginTencent(data.getSign());
            }


            @Override
            protected void onFinish() {

                call.cancel();
            }
        });
    }

    private void loginTencent(String userSig){
        ILiveLoginManager.getInstance().iLiveLogin(SPUtilHelper.getUserId(), userSig, new ILiveCallBack() {
            @Override
            public void onSuccess(Object data) {
                loginInterface.onLoginSDKSuccess();
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                loginInterface.onLoginSDKFailed(module, errCode, errMsg);
            }
        });
    }

    @Override
    public void onForceOffline(int error, String message) {
        loginInterface.updateLoginState(false);
    }
}
