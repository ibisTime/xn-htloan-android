package com.cdkj.huatuweitong.module.reimbursement;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.AdvanceDetailsActivityBean;
import com.cdkj.huatuweitong.bean.SystemEarlyRepaymentBean;
import com.cdkj.huatuweitong.databinding.ActivityAdvanceDetailsBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class AdvanceDetailsActivity extends AbsBaseLoadActivity {
    ActivityAdvanceDetailsBinding mBinding;
    private String bankcardNumber;
    private String restAmount;
    private String toolMoneyPriceDouble;//应还总金额的string值(元)
    private double toolMoney;//应还总金额的double值   (厘)
    private String code;


    /**
     * 剩余金额    银行卡号
     *
     * @param context
     * @param restAmount
     * @param bankcardNumber
     */
    public static void open(Context context, String restAmount, String bankcardNumber, String code) {
        if (context != null) {
            Intent intent = new Intent(context, AdvanceDetailsActivity.class);
            intent.putExtra("restAmount", restAmount);
            intent.putExtra("bankcardNumber", bankcardNumber);
            intent.putExtra("code", code);
            context.startActivity(intent);
        }

    }

    @Override
    public View addMainView() {

        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_advance_details, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("提前还款");

        if (getIntent() != null) {
            bankcardNumber = getIntent().getStringExtra("bankcardNumber");
            restAmount = getIntent().getStringExtra("restAmount");
            code = getIntent().getStringExtra("code");
        }

        mBinding.tvBankNumber.setText(bankcardNumber);
        mBinding.btnSend.setOnClickListener(v -> sendRequest());

        initParameter();
    }

    /**
     * 获取系统参数  得到服务费
     */
    private void initParameter() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("key", "repayment_fee");
        Call call = RetrofitUtils.createApi(MyApiServer.class).getSystemEarlyRepayment("630047", StringUtils.getJsonToString(map));
        addCall(call);
        showLoadingDialog();
        call.enqueue(new BaseResponseModelCallBack<SystemEarlyRepaymentBean>(AdvanceDetailsActivity.this) {
            @Override
            protected void onSuccess(SystemEarlyRepaymentBean data, String SucMessage) {

                String showPriceDouble = MoneyUtils.showPriceDouble(Double.parseDouble(data.getCvalue()));
                String serverPriceDouble = MoneyUtils.showPriceDouble(Double.parseDouble(restAmount));
                toolMoney = Double.parseDouble(data.getCvalue()) + Double.parseDouble(restAmount);
                toolMoneyPriceDouble = MoneyUtils.showPriceDouble(toolMoney);
                mBinding.tvServerMoney.setText(showPriceDouble);
                mBinding.tvLoadMoney.setText(serverPriceDouble);
                mBinding.tvToolMoney.setText(toolMoneyPriceDouble);

            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                mBinding.btnSend.setVisibility(View.GONE);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }

    private void sendRequest() {

        if (TextUtils.isEmpty(toolMoneyPriceDouble)) {
            return;
        }
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("updater", SPUtilHelpr.getUserId());
        Call call = RetrofitUtils.createApi(MyApiServer.class).getAdvanceDetailsActivityBean("630512", StringUtils.getJsonToString(map));
        //去请求网络发起提前还款请求
        call.enqueue(new BaseResponseModelCallBack<AdvanceDetailsActivityBean>(AdvanceDetailsActivity.this) {
            @Override
            protected void onSuccess(AdvanceDetailsActivityBean data, String SucMessage) {
                mBinding.btnSend.setVisibility(View.GONE);

                UITipDialog.showInfo(AdvanceDetailsActivity.this,"提前还款成功");

            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(AdvanceDetailsActivity.this, errorMessage);
                mBinding.btnSend.setVisibility(View.GONE);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }
}
