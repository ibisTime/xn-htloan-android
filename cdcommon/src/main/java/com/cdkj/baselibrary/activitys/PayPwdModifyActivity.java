package com.cdkj.baselibrary.activitys;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cdkj.baselibrary.R;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.databinding.ActivityModifyPayPasswordBinding;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.interfaces.SendCodeInterface;
import com.cdkj.baselibrary.interfaces.SendPhoneCoodePresenter;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.AppUtils;
import com.cdkj.baselibrary.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 修改 设置 支付密码
 * Created by cdkj on 2017/6/29.
 */
@Route(path = CdRouteHelper.PAYPWDMODIFY)
public class PayPwdModifyActivity extends AbsBaseLoadActivity implements SendCodeInterface {

    private ActivityModifyPayPasswordBinding mBinding;

    private boolean mIsSetPwd;//是否设置过密码

    private SendPhoneCoodePresenter mSendCoodePresenter;

    public static final String ISSETPWD = "isSetPwd";
    public static final String MOBILE = "mobile";


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_modify_pay_password, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        if (getIntent() != null) {
            mIsSetPwd = getIntent().getBooleanExtra(ISSETPWD, false);
            mBinding.edtPhone.setText(getIntent().getStringExtra(MOBILE));
            mBinding.edtPhone.setSelection(mBinding.edtPhone.getText().length());
        }

        if (mIsSetPwd) {
            mBaseBinding.titleView.setMidTitle(getString(R.string.change_pay_pwd));
        } else {
            mBaseBinding.titleView.setMidTitle(getString(R.string.set_pay_pwd));
        }
        mSendCoodePresenter = new SendPhoneCoodePresenter(this);
        setListener();
    }

    /**
     * 设置事件
     */
    private void setListener() {
//发送验证码
        mBinding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bizType = "";
                if (mIsSetPwd) {
                    bizType = "805067";//修改
                } else {
                    bizType = "805066";

                }

                mSendCoodePresenter.sendCodeRequest(mBinding.edtPhone.getText().toString(), bizType, MyCdConfig.USERTYPE, PayPwdModifyActivity.this);
            }
        });
//确认
        mBinding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mBinding.edtPhone.getText())) {
                    UITipDialog.showFall(PayPwdModifyActivity.this, getString(R.string.please_input_phone));
                    return;
                }
                if (TextUtils.isEmpty(mBinding.edtCode.getText())) {
                    UITipDialog.showFall(PayPwdModifyActivity.this, getString(R.string.please_input_verification_code));
                    return;
                }

                if (TextUtils.isEmpty(mBinding.edtRepassword.getText())) {
                    UITipDialog.showFall(PayPwdModifyActivity.this, getString(R.string.please_input_pay_pwd));
                    return;
                }
                if (mBinding.edtRepassword.getText().length() < 6) {
                    UITipDialog.showFall(PayPwdModifyActivity.this, getString(R.string.check_pay_pwd));
                    return;
                }

                setPwd();

            }
        });
    }


    private void setPwd() {

        Map<String, String> object = new HashMap<>();

        object.put("userId", SPUtilHelpr.getUserId());
        object.put("token", SPUtilHelpr.getUserToken());
        if (mIsSetPwd) {
            object.put("newTradePwd", mBinding.edtRepassword.getText().toString().trim());
        } else {
            object.put("tradePwd", mBinding.edtRepassword.getText().toString().trim());
        }

        object.put("smsCaptcha", mBinding.edtCode.getText().toString().toString());

        String code = "";
        if (mIsSetPwd) {  //修改
            code = "805067";
        } else {
            code = "805066";
        }

        Call call = RetrofitUtils.getBaseAPiService().successRequest(code, StringUtils.getJsonToString(object));
        addCall(call);
        showLoadingDialog();
        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                if (!data.isSuccess()) {
                    return;
                }

                if (mIsSetPwd) {
                    showToast(getString(R.string.change_succ));
                } else {
                    showToast(getString(R.string.set_succ));

                }
                SPUtilHelpr.saveisTradepwdFlag(true);
                finish();
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(PayPwdModifyActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }


    @Override
    public void CodeSuccess(String msg) {
        mSubscription.add(AppUtils.startCodeDown(60, mBinding.btnSend));
    }

    @Override
    public void CodeFailed(String code, String msg) {
        UITipDialog.showFall(PayPwdModifyActivity.this, msg);
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
        if (mSendCoodePresenter != null) {
            mSendCoodePresenter.clear();
            mSendCoodePresenter = null;
        }
    }
}
