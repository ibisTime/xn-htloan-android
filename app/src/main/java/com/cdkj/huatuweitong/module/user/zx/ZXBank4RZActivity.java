package com.cdkj.huatuweitong.module.user.zx;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.ZXIDCardBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.databinding.ActivityBank4RzBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class ZXBank4RZActivity extends AbsBaseLoadActivity {


    ActivityBank4RzBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXBank4RZActivity.class);
            context.startActivity(intent);
        }
    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_bank4_rz, null, false);
        mBinding.myELBankNumber.requestFocus();//第一个editText获取焦点
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("银行卡四要素");
        initOnClick();
    }

    private void initOnClick() {
        mBinding.btnConfirm.setOnClickListener(v -> {
            if (check()) {
                submit();
            }
        });
    }


    private boolean check() {
        if (TextUtils.isEmpty(mBinding.myELBankNumber.check())) {
            UITipDialog.showInfo(this, "请填写银行卡号");
            return false;
        }
        if (TextUtils.isEmpty(mBinding.myELIdCard.check())) {
            UITipDialog.showInfo(this, "请填写身份证信息");
            return false;
        }
        if (TextUtils.isEmpty(mBinding.myELPhone.check())) {
            UITipDialog.showInfo(this, "请填写手机号码");
            return false;
        }
        if (TextUtils.isEmpty(mBinding.myELName.check())) {
            UITipDialog.showInfo(this, "请填写姓名");
            return false;
        }
        return true;
    }

    private void submit() {
        Map map = new HashMap<String, String>();
        map.put("bankCardNo", mBinding.myELBankNumber.getText());
        map.put("identityNo", mBinding.myELIdCard.getText());
        map.put("mobileNo", mBinding.myELPhone.getText());
        map.put("name", mBinding.myELName.getText());
        map.put("customerName", SPUtilHelper.getRealName());
        Call<BaseResponseModel<ZXSuccessIDBean>> zxid = RetrofitUtils.createApi(MyApiServer.class).getZXRZ("632923", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                ZXIDCardBean zxidCardBean = JSON.parseObject(data.getResult(), new TypeReference<ZXIDCardBean>() {
                });
                if (zxidCardBean == null) {
                    UITipDialog.showInfo(ZXBank4RZActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(zxidCardBean.getCode(), "0000")) {
                    //接口调取成功
                    if (zxidCardBean.getData() != null && TextUtils.equals("一致", zxidCardBean.getData().getResultMsg())) {
                        UITipDialog.showSuccess(ZXBank4RZActivity.this, zxidCardBean.getData().getResultMsg(), dialog -> finish());
                    } else {
                        UITipDialog.showSuccess(ZXBank4RZActivity.this, zxidCardBean.getData().getResultMsg());
                    }
                } else {
                    UITipDialog.showInfo(ZXBank4RZActivity.this, zxidCardBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
