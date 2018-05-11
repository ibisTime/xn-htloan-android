package com.cdkj.baselibrary.interfaces;

import android.content.Context;
import android.text.TextUtils;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.UserLoginModel;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.baselibrary.utils.ToastUtil;

import java.util.HashMap;

import retrofit2.Call;

/**
 * Created by cdkj on 2017/8/8.
 */

public class LoginPresenter {

    private LoginInterface mListener;
    private Context mContext;
    private Call call;

    public LoginPresenter(LoginInterface view) {
        this.mListener = view;
    }

    //处理登录逻辑
    public void login(String username, String password, Context context) {
        this.mContext = context;
        if (TextUtils.isEmpty(username)) {
            UITipDialog.showFall(context, "请输入手机号");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            UITipDialog.showFall(context, "请输入密码");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("loginName", username);
        hashMap.put("loginPwd", password);
        hashMap.put("kind", MyCdConfig.USERTYPE);
        hashMap.put("systemCode", MyCdConfig.SYSTEMCODE);


        call = RetrofitUtils.getBaseAPiService().userLogin("805050", StringUtils.getJsonToString(hashMap));

        mListener.StartLogin();
        call.enqueue(new BaseResponseModelCallBack<UserLoginModel>(mContext) {
            @Override
            protected void onSuccess(UserLoginModel data, String SucMessage) {
                if (!TextUtils.isEmpty(data.getToken()) && !TextUtils.isEmpty(data.getUserId())) {
                    mListener.LoginSuccess(data, "登录成功");
                } else {
                    mListener.LoginFailed("0", "登录失败");
                }
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                mListener.LoginFailed(errorCode, errorMessage);
            }

            @Override
            protected void onNoNet(String msg) {
                mListener.LoginFailed("00", "暂无网络");
            }

            @Override
            protected void onFinish() {
                mListener.EndLogin();
            }
        });
    }

    //处理持有对象
    public void clear() {
        if (this.call != null) {
            this.call.cancel();
            this.call = null;
        }
        this.mListener = null;
        this.mContext = null;
    }


}
