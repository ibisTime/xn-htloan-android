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
import com.cdkj.huatuweitong.bean.SAListBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.databinding.ActivityZxsaBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 涉案查询
 */
public class ZXSAActivity extends AbsBaseLoadActivity {

    ActivityZxsaBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXSAActivity.class);
            context.startActivity(intent);
        }
    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxsa, null, false);
        mBinding.myELIdCard.requestFocus();

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("涉案");
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

        if (TextUtils.isEmpty(mBinding.myELIdCard.check())) {
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
        map.put("identityNo", mBinding.myELIdCard.getText());
        map.put("name", mBinding.myELName.getText());
        Call<BaseResponseModel<ZXSuccessIDBean>> zxid = RetrofitUtils.createApi(MyApiServer.class).getZXRZ("632921", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxid.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                SAListBean saListBean = JSON.parseObject(data.getResult(), new TypeReference<SAListBean>() {
                });
                if (saListBean == null) {
                    UITipDialog.showInfo(ZXSAActivity.this, "认证失败请重试");
                    return;
                }
                if (TextUtils.equals(saListBean.getCode(), "0000")) {
                    UITipDialog.showSuccess(ZXSAActivity.this, saListBean.getMsg(), dialog -> finish());
//                    if (TextUtils.equals(saListBean.getMsg(), "查询成功无数据")) {
//                    } else {
//                        //展示的事  当有涉案数据时的详情,aap无需显示  只要查询成功即可
//                        // ZXSAListActivity.open(ZXSAActivity.this, saListBean.getData(), mBinding.myELIdCard.getText(), mBinding.myELName.getText());
//                    }

                } else {
                    UITipDialog.showInfo(ZXSAActivity.this, saListBean.getMsg());
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
