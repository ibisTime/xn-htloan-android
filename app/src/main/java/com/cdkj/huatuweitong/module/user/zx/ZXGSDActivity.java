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
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.SBAreaListBean;
import com.cdkj.huatuweitong.bean.ZXGSDBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.databinding.ActivityZxgsdBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 运营商归属地查询
 */

public class ZXGSDActivity extends AbsBaseLoadActivity {

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_zxgsd);
//    }
    ActivityZxgsdBinding mBinding;
    public SBAreaListBean addressList;//地区列表

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXGSDActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxgsd, null, false);
        mBinding.myELMobileNo.requestFocus();
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("运营商归属地");
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
        if (TextUtils.isEmpty(mBinding.myELMobileNo.check())) {
            return false;
        }
        return true;
    }

    private void submit() {
        Map map = new HashMap<String, String>();
        map.put("mobileNo", mBinding.myELMobileNo.getText());//账号
        Call<BaseResponseModel<ZXSuccessIDBean>> zxid = RetrofitUtils.createApi(MyApiServer.class).getZXRZ("632933", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                ZXGSDBean zxgsdBean = JSON.parseObject(data.getResult(), new TypeReference<ZXGSDBean>() {
                });
                if (zxgsdBean == null) {
                    UITipDialog.showInfo(ZXGSDActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(zxgsdBean.getCode(), "0000")) {
                    UITipDialog.showSuccess(ZXGSDActivity.this, "成功");
                    ZXGSDBean.DataBean data1 = zxgsdBean.getData();
                    if (data1 != null) {
                        mBinding.llGsd.setVisibility(View.VISIBLE);
                        mBinding.rilType.setTvRight(data1.getType());
                        mBinding.rilGsd.setTvRight((TextUtils.isEmpty(data1.getProvince()) ? "" : data1.getProvince()) + (TextUtils.isEmpty(data1.getCity()) ? "" : data1.getCity()));
                    }

                } else {
                    UITipDialog.showInfo(ZXGSDActivity.this, zxgsdBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
