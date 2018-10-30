package com.cdkj.huatuweitong.module.user.zx;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
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
import com.cdkj.baselibrary.nets.rx.BaseResponseModelNoTokenCallBack;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.ZXDSBean;
import com.cdkj.huatuweitong.bean.ZXSuccessBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.databinding.ActivityZxdsBinding;
import com.cdkj.huatuweitong.utlis.Base64Utils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 电商
 */
public class ZXDSActivity extends AbsBaseLoadActivity {
    ActivityZxdsBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXDSActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxds, null, false);
        mBinding.myELIdentityCardNo.requestFocus();
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("电商");
        initOnClick();
    }

    private void initOnClick() {
        mBinding.btnConfirm.setOnClickListener(v -> {
            if (check()) {
                getToken();
            }
        });
    }

    /**
     * 1.获取token
     */
    private void getToken() {
        Map<String, String> map = new HashMap<>();
        map.put("identityCardNo", mBinding.myELIdentityCardNo.getText());
        map.put("identityName", mBinding.myELIdentityName.getText());
        map.put("username", mBinding.myELUsername.getText());
        map.put("loginType", "qr");
        map.put("customerName", SPUtilHelper.getRealName());

        Call<BaseResponseModel<ZXSuccessIDBean>> zxrz = RetrofitUtils.createApi(MyApiServer.class).getZXRZ("632939", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxrz.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                ZXSuccessBean zxSuccessBean = JSON.parseObject(data.getResult(), new TypeReference<ZXSuccessBean>() {
                });
                if (zxSuccessBean == null) {
                    UITipDialog.showInfo(ZXDSActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(zxSuccessBean.getCode(), "0010")) {
                    UITipDialog.showSuccess(ZXDSActivity.this, "成功", dialog -> {
                        getMSM(zxSuccessBean.getToken());
                    });

                } else {
                    UITipDialog.showInfo(ZXDSActivity.this, zxSuccessBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 2.获取验证码
     */
    private void getMSM(String token) {

        Map<String, String> map = new HashMap<>();
        map.put("tokendb", token);

        Call<BaseResponseModel<String>> zxrz = RetrofitUtils.createApi(MyApiServer.class).getZXRZ2("632940", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxrz.enqueue(new BaseResponseModelNoTokenCallBack<String>(this) {
            @Override
            protected void onSuccess(String data, String SucMessage) {
//                showDialog(token);
                ZXDSBean zxdsBean = JSON.parseObject(data, new TypeReference<ZXDSBean>() {
                });
                if (zxdsBean != null & zxdsBean.getInput() != null && !TextUtils.isEmpty(zxdsBean.getInput().getValue())) {
                    Bitmap bitmap = Base64Utils.base64ToBitmap(zxdsBean.getInput().getValue());
                    mBinding.llQr.setVisibility(View.VISIBLE);
                    mBinding.ivQr.setImageBitmap(bitmap);

//                    getDetail(zxdsBean.getCode());

                } else {
                    UITipDialog.showSuccess(ZXDSActivity.this, "查询失败", dialog -> {

                    });
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private void getDetail(String code) {
        Map<String, String> map = new HashMap<>();
        map.put("id", code);
        Call<BaseResponseModel<String>> zxdsDetails = RetrofitUtils.createApi(MyApiServer.class).getZXDSDetails("632948", StringUtils.getJsonToString(map));
        zxdsDetails.enqueue(new BaseResponseModelCallBack<String>(this) {
            @Override
            protected void onSuccess(String data, String SucMessage) {

            }

            @Override
            protected void onFinish() {

            }
        });
    }


    private boolean check() {

        if (TextUtils.isEmpty(mBinding.myELIdentityCardNo.check())) {
            return false;
        }
        if (TextUtils.isEmpty(mBinding.myELIdentityName.check())) {
            return false;
        }
        if (TextUtils.isEmpty(mBinding.myELUsername.check())) {
            return false;
        }

        return true;
    }

//    private void showDialog(String token) {
//        InputDialog inputDialog = new InputDialog(ZXDSActivity.this).builder();
//        inputDialog.setTitle("请输入收到的验证码");
//        inputDialog.setContentHintMsg("验证码");
//        inputDialog.setPositiveBtn("确定", (view, inputMsg) -> {
//            String sms = inputDialog.getContentView().getText().toString();
//            if (TextUtils.isEmpty(sms)) {
//                UITipDialog.showInfo(ZXDSActivity.this, "验证码不正确");
//                return;
//            }
//            submit(token, sms);
//        });
//        inputDialog.setNegativeBtn("取消", null);
//        inputDialog.show();
//    }
//
//    private void submit(String token, String sms) {
//        Map map = new HashMap<String, String>(2);
//        map.put("input", sms);
//        map.put("tokendb", token);
//        Call<BaseResponseModel<String>> zxrz = RetrofitUtils.createApi(MyApiServer.class).getZXRZ2("632941", StringUtils.getJsonToString(map));
//        showLoadingDialog();
//        zxrz.enqueue(new BaseResponseModelCallBack<String>(this) {
//            @Override
//            protected void onSuccess(String data, String SucMessage) {
//                ZXSuccessBean zxSuccessBean = JSON.parseObject(data, new TypeReference<ZXSuccessBean>() {
//                });
//                if (zxSuccessBean == null) {
//                    UITipDialog.showInfo(ZXDSActivity.this, "认证失败请重试");
//                    return;
//                }
//                if (TextUtils.equals(zxSuccessBean.getCode(), "0010")) {
//                    UITipDialog.showSuccess(ZXDSActivity.this, "成功", dialog -> {
//                        finish();
//                    });
//                } else {
//                    UITipDialog.showInfo(ZXDSActivity.this, zxSuccessBean.getMsg());
//                }
//            }
//
//            @Override
//            protected void onFinish() {
//                disMissLoading();
//            }
//        });
//    }
}
