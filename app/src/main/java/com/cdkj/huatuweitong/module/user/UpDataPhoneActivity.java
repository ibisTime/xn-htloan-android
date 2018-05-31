package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.interfaces.SendCodeInterface;
import com.cdkj.baselibrary.interfaces.SendPhoneCoodePresenter;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.AppUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityUpDataPhoneBinding;

import java.util.HashMap;
import java.util.LinkedHashMap;

import retrofit2.Call;

public class UpDataPhoneActivity extends AbsBaseLoadActivity implements SendCodeInterface {
    ActivityUpDataPhoneBinding mBinding;
    private SendPhoneCoodePresenter mSendCOdePresenter;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, UpDataPhoneActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_up_data_phone, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.UpDataPhoneActivityTitle));

        mSendCOdePresenter = new SendPhoneCoodePresenter(this);

        mBinding.btnCheckCode.setOnClickListener(v -> {

            mSendCOdePresenter.sendCodeRequest(mBinding.etPhone.getText().toString(), "805061", MyCdConfig.USERTYPE, UpDataPhoneActivity.this);

        });

        mBinding.btnYesUpdataPsw.setOnClickListener(v -> {

            if (TextUtils.isEmpty(mBinding.etPhone.getText().toString())) {
                UITipDialog.showFall(UpDataPhoneActivity.this, getString(com.cdkj.baselibrary.R.string.please_input_phone));
                return;
            }
            if (TextUtils.isEmpty(mBinding.etCheckCode.getText().toString())) {
                UITipDialog.showFall(UpDataPhoneActivity.this, getString(com.cdkj.baselibrary.R.string.please_input_verification_code));
                return;
            }
            reqeustUpPhoneNumber();
        });


    }

    /**
     * 请求接口修改手机号
     */
    private void reqeustUpPhoneNumber() {
        HashMap<String, String> hashMap = new LinkedHashMap<String, String>();
        showLoadingDialog();
        hashMap.put("newMobile", mBinding.etPhone.getText().toString());
        hashMap.put("smsCaptcha", mBinding.etCheckCode.getText().toString());
        hashMap.put("userId", SPUtilHelpr.getUserId());

        Call call = RetrofitUtils.getBaseAPiService().successRequest("805061", StringUtils.getJsonToString(hashMap));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(UpDataPhoneActivity.this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                if (data.isSuccess()) {
                    SPUtilHelpr.saveUserPhoneNum(mBinding.etPhone.getText().toString());
                    UITipDialog.showSuccess(UpDataPhoneActivity.this, getString(R.string.noupdata_phone_succer),dialog -> finish() );
                } else {
                    UITipDialog.showFall(UpDataPhoneActivity.this, getString(R.string.noupdata_phone));
                }
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                // super.onReqFailure(errorCode, errorMessage);
                Log.i("pppppp", "onReqFailure: "+errorMessage);
                UITipDialog.showFall(UpDataPhoneActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });

    }


    @Override
    public void CodeSuccess(String msg) {
        mSubscription.add(AppUtils.startCodeDown(60, mBinding.btnCheckCode));
    }

    @Override
    public void CodeFailed(String code, String msg) {

        UITipDialog.showFall(UpDataPhoneActivity.this, msg);
    }

    @Override
    public void StartSend() {
        showLoadingDialog();
    }

    @Override
    public void EndSend() {
        disMissLoading();
    }
}
