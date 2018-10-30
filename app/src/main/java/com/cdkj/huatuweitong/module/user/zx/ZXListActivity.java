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
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.bean.ZXTypeBean;
import com.cdkj.huatuweitong.databinding.ActivityZxlistBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class ZXListActivity extends AbsBaseLoadActivity {
    ActivityZxlistBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, ZXListActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_zxlist, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("征信认证");
        initOnClick();


    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("userId", SPUtilHelper.getIdCarde());
        Call<BaseResponseModel<ZXTypeBean>> zxType = RetrofitUtils.createApi(MyApiServer.class).getZXType("632946", StringUtils.getJsonToString(map));
        showLoadingDialog();
        zxType.enqueue(new BaseResponseModelCallBack<ZXTypeBean>(this) {
            @Override
            protected void onSuccess(ZXTypeBean data, String SucMessage) {
                setData(data);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    public ZXSuccessIDBean stringToBean(String json) {
        if (TextUtils.isEmpty(json)) {
            return new ZXSuccessIDBean();
        }
        ZXSuccessIDBean zxSuccessBean = JSON.parseObject(json, new TypeReference<ZXSuccessIDBean>() {
        });
        return zxSuccessBean;
    }


    /**
     * 设置状态
     *
     * @param data
     */
    private void setData(ZXTypeBean data) {
        ZXSuccessIDBean identity = stringToBean(data.getIdentity());
        //身份证实名认证
        if (identity.getStatus()==0) {
            mBinding.rilIdCard.setTvRight("未认证");
        } else {
            mBinding.rilIdCard.setTvRight(identity.getStatus() == 2 ? "已认证" : "认证中");
        }
        //银行卡四要素认证
        ZXSuccessIDBean bank4 = stringToBean(data.getBankcard4check());
        if (bank4.getStatus()==0) {
            mBinding.rilBank4.setTvRight("未认证");
        } else {
            mBinding.rilBank4.setTvRight(bank4.getStatus() == 2 ? "已认证" : "认证中");
        }

        //运营商
        ZXSuccessIDBean mobileReportTask = stringToBean(data.getMobileReportTask());
        if (mobileReportTask.getStatus()==0) {
            mBinding.rilYys.setTvRight("未认证");
        } else {
            mBinding.rilYys.setTvRight(mobileReportTask.getStatus() == 2 ? "已认证" : "认证中");
        }
        //电商
        ZXSuccessIDBean taobaoReport = stringToBean(data.getTaobao_report());
        if (taobaoReport.getStatus()==0) {
            mBinding.rilDs.setTvRight("未认证");
        } else {
            mBinding.rilDs.setTvRight(taobaoReport.getStatus() == 2 ? "已认证" : "认证中");
        }
        //京东
        ZXSuccessIDBean jd = stringToBean(data.getJd());
        if (jd.getStatus()==0) {
            mBinding.rilJd.setTvRight("未认证");
        } else {
            mBinding.rilJd.setTvRight(jd.getStatus() == 2 ? "已认证" : "认证中");
        }


//        //社保
//        ZXSuccessIDBean socialsecurity = stringToBean(data.getSocialsecurity());
//        if (TextUtils.isEmpty(socialsecurity.getStatus() + "")) {
//            mBinding.rilSb.setTvRight("未认证");
//        } else {
//            mBinding.rilSb.setTvRight(socialsecurity.getStatus()==2 ? "已认证" : "认证中");
//        }
//
//        //失信人
//        ZXSuccessIDBean shixin = stringToBean(data.getShixin());
//        if (TextUtils.isEmpty(shixin.getStatus() + "")) {
//            mBinding.rilSx.setTvRight("未认证");
//        } else {
//            mBinding.rilSx.setTvRight(shixin.getStatus()==2 ? "已认证" : "认证中");
//        }
    }

    private void initOnClick() {
        //身份证实名认证
        mBinding.rilIdCard.setOnClickListener(v -> {

            if (TextUtils.equals(mBinding.rilIdCard.getRightTxt(), "已认证")) {
                UITipDialog.showSuccess(this, "无需重复验证");
                return;
            }
            IDCardAuthenticationActivity.open(this);
        });
        //银行卡四要素认证
        mBinding.rilBank4.setOnClickListener(v -> {
            if (TextUtils.equals(mBinding.rilBank4.getRightTxt(), "已认证")) {
                UITipDialog.showSuccess(this, "无需重复验证");
                return;
            }
            ZXBank4RZActivity.open(this);
        });

        //京东
        mBinding.rilJd.setOnClickListener(v -> {
            if (TextUtils.equals(mBinding.rilJd.getRightTxt(), "已认证")) {
                UITipDialog.showSuccess(this, "无需重复验证");
                return;
            }
            if (TextUtils.isEmpty(SPUtilHelper.getIdCarde())) {
                UITipDialog.showInfo(this, "请先去进行实名认证");
                return;
            }
            ZXJDActivity.open(this);
        });

        //运营商
        mBinding.rilYys.setOnClickListener(v -> {
            if (TextUtils.equals(mBinding.rilYys.getRightTxt(), "已认证")) {
                UITipDialog.showSuccess(this, "无需重复验证");
                return;
            }
            ZXYYSActivity.open(this);
        });
        //电商
        mBinding.rilDs.setOnClickListener(v -> {
            if (TextUtils.equals(mBinding.rilDs.getRightTxt(), "已认证")) {
                UITipDialog.showSuccess(this, "无需重复验证");
                return;
            }
            ZXDSActivity.open(this);
        });

        //社保
        mBinding.rilSb.setVisibility(View.GONE);
        mBinding.rilSb.setOnClickListener(v -> {
            if (TextUtils.isEmpty(SPUtilHelper.getIdCarde())) {
                UITipDialog.showInfo(this, "请先去进行实名认证");
                return;
            }
            ZXYBActivity.open(this);
        });
        //涉案
        mBinding.rilSa.setVisibility(View.GONE);
        mBinding.rilSa.setOnClickListener(v -> {
            ZXSAActivity.open(this);
        });
        //失信被执行人
        mBinding.rilSx.setVisibility(View.GONE);
        mBinding.rilSx.setOnClickListener(v -> {
            ZXSXActivity.open(this);
        });
        //公积金
        mBinding.rilGjj.setVisibility(View.GONE);
        mBinding.rilGjj.setOnClickListener(v -> {
            if (TextUtils.isEmpty(SPUtilHelper.getIdCarde())) {
                UITipDialog.showInfo(this, "请先去进行实名认证");
                return;
            }
            ZXGJJActivity.open(this);
        });
        //淘宝
        mBinding.rilTb.setVisibility(View.GONE);
        mBinding.rilTb.setOnClickListener(v -> {
            if (TextUtils.isEmpty(SPUtilHelper.getIdCarde())) {
                UITipDialog.showInfo(this, "请先去进行实名认证");
                return;
            }
            ZXTBActivity.open(this);
        });

        //归属地
        mBinding.rilGsd.setVisibility(View.GONE);
        mBinding.rilGsd.setOnClickListener(v -> {
            ZXGSDActivity.open(this);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }
}
