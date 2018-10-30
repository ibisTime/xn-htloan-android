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
import com.cdkj.huatuweitong.databinding.ActivityIdcardAuthenticationBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class IDCardAuthenticationActivity extends AbsBaseLoadActivity {
    ActivityIdcardAuthenticationBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, IDCardAuthenticationActivity.class);
            context.startActivity(intent);
        }
    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_idcard_authentication, null, false);
        mBinding.myELId.requestFocus();//第一个editText获取焦点
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("身份证认证");
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
        if (TextUtils.isEmpty(mBinding.myELId.check())) {
            UITipDialog.showInfo(this, "请填写身份证信息");
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
        map.put("identityNo", mBinding.myELId.getText());
        map.put("name", mBinding.myELName.getText());
        map.put("userId", SPUtilHelper.getUserId());
        Call<BaseResponseModel<ZXSuccessIDBean>> zxid =  RetrofitUtils.createApi(MyApiServer.class).getZXID("632920", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                ZXIDCardBean zxidCardBean = JSON.parseObject(data.getResult(), new TypeReference<ZXIDCardBean>() {
                });
                if (zxidCardBean == null) {
                    UITipDialog.showInfo(IDCardAuthenticationActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(zxidCardBean.getCode(), "0000") && TextUtils.equals(zxidCardBean.getMsg(), "成功")) {
                    if (zxidCardBean.getData() != null && TextUtils.equals("一致", zxidCardBean.getData().getResultMsg())) {
                        SPUtilHelper.saveIdCarde(zxidCardBean.getData().getIdentityNo());
                        SPUtilHelper.saveRealName(zxidCardBean.getData().getName());
                        UITipDialog.showSuccess(IDCardAuthenticationActivity.this, zxidCardBean.getData().getResultMsg(), dialog -> finish());
                    } else {
                        UITipDialog.showSuccess(IDCardAuthenticationActivity.this, zxidCardBean.getData().getResultMsg());
                    }
                } else {
                    UITipDialog.showInfo(IDCardAuthenticationActivity.this, zxidCardBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

}
