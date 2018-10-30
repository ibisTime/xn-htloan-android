package com.cdkj.huatuweitong.module.user.zx;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.cdkj.huatuweitong.adapters.SXListAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.SXDetailsBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.databinding.ActivityZxsxBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 失信被执行人
 */
public class ZXSXActivity extends AbsBaseLoadActivity {

    ActivityZxsxBinding mBinding;


    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXSXActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxsx, null, false);
        mBinding.myELIdentityNo.requestFocus();

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("失信被执行人");
        mBinding.btnConfirm.setOnClickListener(v -> {
            if (check()) {
                getDetails();
            }
        });
    }

    private boolean check() {
        if (TextUtils.isEmpty(mBinding.myELIdentityNo.getText())) {
            UITipDialog.showInfo(this, "请输入证件号码");
            return false;
        }
        if (TextUtils.isEmpty(mBinding.myELName.getText())) {
            UITipDialog.showInfo(this, "请输入姓名");
            return false;
        }
        return true;
    }

    private void getDetails() {
        Map map = new HashMap<String, String>();
        map.put("identityNo", mBinding.myELIdentityNo.getText());
        map.put("name", mBinding.myELName.getText());

        Call<BaseResponseModel<ZXSuccessIDBean>> zxid = RetrofitUtils.createApi(MyApiServer.class).getZXRZ("632924", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                SXDetailsBean sxDetailsBean = JSON.parseObject(data.getResult(), new TypeReference<SXDetailsBean>() {
                });

                if (sxDetailsBean == null) {
                    UITipDialog.showInfo(ZXSXActivity.this, "查询失败");
                    return;
                }
                if (TextUtils.equals(sxDetailsBean.getCode(), "0000")) {
                    UITipDialog.showSuccess(ZXSXActivity.this, "查询成功", dialog -> {
                        finish();
                    });
                } else {
                    UITipDialog.showInfo(ZXSXActivity.this, sxDetailsBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    private void setView(List<SXDetailsBean.DataBean.DishonestsBean> data) {
        if (data == null || data.size() == 0) {
            UITipDialog.showInfo(this, "暂无数据");
            return;
        }
        mBinding.llDetials.setVisibility(View.VISIBLE);
        SXListAdapter adapter = new SXListAdapter(data);
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.rv.setAdapter(adapter);
    }
}
