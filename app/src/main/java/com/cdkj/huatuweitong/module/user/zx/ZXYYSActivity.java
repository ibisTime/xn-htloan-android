package com.cdkj.huatuweitong.module.user.zx;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.InputDialog;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.nets.rx.BaseResponseModelNoTokenCallBack;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.ZXSuccessBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.databinding.ActivityZxyysBinding;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Call;

/**
 * 运营商
 */
public class ZXYYSActivity extends AbsBaseLoadActivity {

    ActivityZxyysBinding mBinding;
    private String token;
    private Disposable subscribe;
    private AlertDialog messageDialog;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXYYSActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxyys, null, false);
        mBinding.myELBankcard.requestFocus();
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("运营商");
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
//        map.put("bankcard", mBinding.myELBankcard.getText());
        map.put("identityCardNo", mBinding.myELIdentityCardNo.getText());
        map.put("identityName", mBinding.myELIdentityName.getText());
        map.put("password", mBinding.myELPassword.getText());
        map.put("username", mBinding.myELUsername.getText());
        Call<BaseResponseModel<ZXSuccessIDBean>> zxrz = RetrofitUtils.createApi(MyApiServer.class).getZXRZ("632934", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxrz.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                ZXSuccessBean zxSuccessBean = JSON.parseObject(data.getResult(), new TypeReference<ZXSuccessBean>() {
                });
                if (zxSuccessBean == null) {
                    UITipDialog.showInfo(ZXYYSActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(zxSuccessBean.getCode(), "0010")) {
                    UITipDialog.showSuccess(ZXYYSActivity.this, "成功", dialog -> {
                        token = zxSuccessBean.getToken();
                        getMSM();
                    });

                } else {
                    UITipDialog.showInfo(ZXYYSActivity.this, zxSuccessBean.getMsg());
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
    private void getMSM() {
        Map<String, String> map = new HashMap<>();
        map.put("tokendb", token);

        Call<BaseResponseModel<String>> zxrz = RetrofitUtils.createApi(MyApiServer.class).getZXRZ2("632935", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxrz.enqueue(new BaseResponseModelNoTokenCallBack<String>(this) {
            @Override
            protected void onSuccess(String data, String SucMessage) {

                InputDialog inputDialog = new InputDialog(ZXYYSActivity.this).builder();
                inputDialog.setTitle("请输入收到的验证码");
                inputDialog.setContentHintMsg("输入验证码");
                inputDialog.setPositiveBtn("确定", (view, inputMsg) -> {
                    String sms = inputDialog.getContentView().getText().toString();
                    if (TextUtils.isEmpty(sms)) {
                        UITipDialog.showInfo(ZXYYSActivity.this, "验证码不正确");
                        return;
                    }
                    submit(sms);

                });
                inputDialog.setNegativeBtn("取消", new InputDialog.OnNegativeListener() {
                    @Override
                    public void onNegative(View view, String inputMsg) {

                    }
                });
                inputDialog.show();
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private void submit(String sms) {
        Map map = new HashMap<String, String>(2);
        map.put("input", sms);
        map.put("tokendb", token);
        Call<BaseResponseModel<String>> zxrz = RetrofitUtils.createApi(MyApiServer.class).getZXRZ2("632936", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxrz.enqueue(new BaseResponseModelCallBack<String>(this) {
            @Override
            protected void onSuccess(String data, String SucMessage) {
                ZXSuccessBean zxSuccessBean = JSON.parseObject(data, new TypeReference<ZXSuccessBean>() {
                });
                if (zxSuccessBean == null) {
                    UITipDialog.showInfo(ZXYYSActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(zxSuccessBean.getCode(), "0009")) {
                    UITipDialog.showSuccess(ZXYYSActivity.this, "成功", dialog -> {
//                        finish();
//                        outputData();
                        startTime();
                    });
                } else {
                    UITipDialog.showInfo(ZXYYSActivity.this, zxSuccessBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private void startTime() {

        Observable<Long> interval = Observable.interval(0, 5, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
        subscribe = interval    // 创建一个按照给定的时间间隔发射从0开始的整数序列
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .take(10)//只发射开始的N项数据或者一定时间内的数据
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        LogUtil.E("pppppp" + aLong);
                        if (messageDialog == null || !messageDialog.isShowing())
                            messageDialog = new AlertDialog.Builder(ZXYYSActivity.this)
                                    .setTitle("请稍等")
                                    .setMessage("可能会持续一段时间请稍等")
                                    .setCancelable(false).show();
                        outputData(aLong);
                    }
                });

    }


    /**
     * 成功以后将数据写入
     */
    private void outputData(Long along) {
        HashMap<String, String> map = new HashMap<>();
        map.put("tokendb", token);
        Call<BaseResponseModel<String>> zxrz2 = RetrofitUtils.createApi(MyApiServer.class).getZXRZ2("632937", StringUtils.getJsonToString(map));

        zxrz2.enqueue(new BaseResponseModelCallBack<String>(this) {
            @Override
            protected void onSuccess(String data, String SucMessage) {
                ZXSuccessBean zxSuccessBean = JSON.parseObject(data, new TypeReference<ZXSuccessBean>() {
                });
                if (zxSuccessBean == null) {
                    UITipDialog.showInfo(ZXYYSActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(zxSuccessBean.getCode(), "0000")) {
                    if (messageDialog == null || messageDialog.isShowing()) {
                        messageDialog.dismiss();
                    }
                    if (subscribe != null) {
                        subscribe.dispose();//取消订阅
                    }
                    UITipDialog.showSuccess(ZXYYSActivity.this, "成功", dialog -> {
                        finish();
                    });
                } else {
                    if (along >= 9)
                        messageDialog.dismiss();
                    UITipDialog.showInfo(ZXYYSActivity.this, "正在重试");
                }
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                messageDialog.dismiss();
                UITipDialog.showInfo(ZXYYSActivity.this, "请重试");
            }

            @Override
            protected void onFinish() {
//                disMissLoading();
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
        if (TextUtils.isEmpty(mBinding.myELPassword.check())) {
            return false;
        }
        return true;
    }
}
