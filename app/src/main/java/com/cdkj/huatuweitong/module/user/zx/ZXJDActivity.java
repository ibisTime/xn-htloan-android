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
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.ZXSuccessBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.bean.ZXTBqrBean;
import com.cdkj.huatuweitong.databinding.ActivityZxjdBinding;
import com.cdkj.huatuweitong.utlis.Base64Utils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class ZXJDActivity extends AbsBaseLoadActivity {

    ActivityZxjdBinding mBinding;


    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXJDActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxjd, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("京东");
        getTooken();
    }

    private void getTooken() {
        Map map = new HashMap<String, String>();
        map.put("loginType", "qr");
        map.put("idNo", SPUtilHelper.getIdCarde());//身份证从用详情中取
        map.put("customerName", SPUtilHelper.getRealName());//姓名从用详情中取
        map.put("password", "123456");
        map.put("username", "账号");

        Call<BaseResponseModel<ZXSuccessIDBean>> zxid = RetrofitUtils.createApi(MyApiServer.class).getZXRZ("632931", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                ZXSuccessBean zxSuccessBean = JSON.parseObject(data.getResult(), new TypeReference<ZXSuccessBean>() {
                });
                if (zxSuccessBean == null) {
                    UITipDialog.showInfo(ZXJDActivity.this, "查询失败");
                    finish();
                    return;
                }
                if (TextUtils.equals(zxSuccessBean.getCode(), "0010")) {

                    UITipDialog.showSuccess(ZXJDActivity.this, "成功", dialog -> {
                        getDetails(zxSuccessBean.getToken());
                    });
                } else {
                    UITipDialog.showSuccess(ZXJDActivity.this, zxSuccessBean.getMsg(), dialog -> {
                        finish();
                    });
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }


    private void getDetails(String token) {
        Map map = new HashMap<String, String>();
        map.put("tokendb", token);
        map.put("bizType", "jd");

        Call<BaseResponseModel<String>> zxid = RetrofitUtils.createApi(MyApiServer.class).getZXRZ2("632944", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<String>(this) {
            @Override
            protected void onSuccess(String data, String SucMessage) {
                ZXTBqrBean zxtBqrBean = JSON.parseObject(data, new TypeReference<ZXTBqrBean>() {
                });
                if (zxtBqrBean != null & zxtBqrBean.getInput() != null && !TextUtils.isEmpty(zxtBqrBean.getInput().getValue())) {
                    Bitmap bitmap = Base64Utils.base64ToBitmap(zxtBqrBean.getInput().getValue());
                    mBinding.llQr.setVisibility(View.VISIBLE);
                    mBinding.ivQr.setImageBitmap(bitmap);
                } else {
                    UITipDialog.showSuccess(ZXJDActivity.this, "查询失败", dialog -> {
                        finish();
                    });
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

}
