package com.cdkj.baselibrary.activitys.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;


import com.cdkj.baselibrary.MainActivity;
import com.cdkj.baselibrary.R;
import com.cdkj.baselibrary.api.BaseApiServer;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.databinding.ActivityRegisterBinding;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.interfaces.SendCodeInterface;
import com.cdkj.baselibrary.interfaces.SendPhoneCoodePresenter;
import com.cdkj.baselibrary.model.UserLoginModel;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.AppUtils;
import com.cdkj.baselibrary.utils.StringUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import retrofit2.Call;

/**
 * Created by cdkj on 2017/8/8.
 */
public class RegisterActivity extends AbsBaseLoadActivity implements SendCodeInterface {

    private ActivityRegisterBinding mBinding;

    private SendPhoneCoodePresenter mSendCOdePresenter;


    /**
     * 打开当前页面
     *
     * @param context
     */
    public static void open(Context context) {
        if (context == null) {
            return;
        }
        context.startActivity(new Intent(context, RegisterActivity.class));
    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_register, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mSendCOdePresenter = new SendPhoneCoodePresenter(this);
        mBaseBinding.titleView.setMidTitle(getString(R.string.register));
        initListener();
    }

    private void initListener() {
        mBinding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPhoneNumAndSendCode();
            }
        });


        //注册
        mBinding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mBinding.edtPhone.getText().toString())) {
                    UITipDialog.showFall(RegisterActivity.this, getString(R.string.please_input_phone));
                    return;
                }
                if (TextUtils.isEmpty(mBinding.edtCode.getText().toString())) {
                    UITipDialog.showFall(RegisterActivity.this, getString(R.string.please_input_verification_code));
                    return;
                }
                if (TextUtils.isEmpty(mBinding.edtPassword.getText().toString())) {
                    UITipDialog.showFall(RegisterActivity.this, getString(R.string.please_input_pwd));
                    return;
                }
                if (mBinding.edtPassword.getText().toString().length() < 6) {
                    UITipDialog.showFall(RegisterActivity.this, getString(R.string.check_pwd_info));
                    return;
                }

                if (TextUtils.isEmpty(mBinding.edtRepassword.getText().toString())) {
                    UITipDialog.showFall(RegisterActivity.this, getString(R.string.please_reinput_pwd));
                    return;
                }
                if (!TextUtils.equals(mBinding.edtRepassword.getText().toString(), mBinding.edtPassword.getText().toString())) {
                    UITipDialog.showFall(RegisterActivity.this, getString(R.string.check_pwd_info_2));
                    return;
                }

                registeRequest();
            }
        });


    }

    /**
     * 检车手机号是否可以注册然后发送验证码
     */
    private void checkPhoneNumAndSendCode() {
        if (TextUtils.isEmpty(mBinding.edtPhone.getText().toString())) {
            UITipDialog.showFall(RegisterActivity.this, getString(R.string.please_input_phone));
            return;
        }
        mSendCOdePresenter.sendCodeRequest(mBinding.edtPhone.getText().toString(), "805041", MyCdConfig.USERTYPE, RegisterActivity.this);
    }


    /**
     * 注册请求
     */
    private void registeRequest() {

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("mobile", mBinding.edtPhone.getText().toString());
        hashMap.put("loginPwd", mBinding.edtPassword.getText().toString());
        hashMap.put("kind", MyCdConfig.USERTYPE);
        hashMap.put("smsCaptcha", mBinding.edtCode.getText().toString());
        hashMap.put("systemCode", MyCdConfig.SYSTEMCODE);
        hashMap.put("companyCode", MyCdConfig.COMPANYCODE);

        Call call = RetrofitUtils.createApi(BaseApiServer.class).userRegister("805041", StringUtils.getJsonToString(hashMap));

        addCall(call);

        showLoadingDialog();
        call.enqueue(new BaseResponseModelCallBack<UserLoginModel>(this) {
            @Override
            protected void onSuccess(UserLoginModel data, String SucMessage) {
                if (!TextUtils.isEmpty(data.getToken()) && !TextUtils.isEmpty(data.getUserId())) {

                    showToast(getString(R.string.register_succ));

                    SPUtilHelpr.saveUserId(data.getUserId());
                    SPUtilHelpr.saveUserToken(data.getToken());
                    SPUtilHelpr.saveUserPhoneNum(mBinding.edtPhone.getText().toString());

                    finish();

                }
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(RegisterActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    //获取验证码相关
    @Override
    public void CodeSuccess(String msg) {
        UITipDialog.showSuccess(RegisterActivity.this, msg);
        mSubscription.add(AppUtils.startCodeDown(60, mBinding.btnSend));//启动倒计时
    }

    @Override
    public void CodeFailed(String code, String msg) {
        UITipDialog.showFall(RegisterActivity.this, msg);
    }

    @Override
    public void StartSend() {
        showLoadingDialog();
    }

    @Override
    public void EndSend() {
        disMissLoading();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSendCOdePresenter != null) {
            mSendCOdePresenter.clear();
            mSendCOdePresenter = null;
        }
    }
}
