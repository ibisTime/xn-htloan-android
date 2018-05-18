package com.cdkj.huatuweitong.module.reimbursement;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityBean;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityMonthBean;
import com.cdkj.huatuweitong.databinding.ActivityCarLoanDetailsBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class CarLoanDetailsActivity extends AbsBaseLoadActivity {

    private ActivityCarLoanDetailsBinding mBinding;
    private String code;
    private String type;//1代表是 本月应还的   2代表是所有的贷款
    private CarLoanDetailsActivityBean mdata;

    public static void open(Context context, String code, String type) {
        if (context != null) {
//            630541
            Intent intent = new Intent(context, CarLoanDetailsActivity.class);
            intent.putExtra("code", code);
            intent.putExtra("type", type);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_car_loan_details, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("贷款详情");
        if (getIntent() != null) {
            code = getIntent().getStringExtra("code");
            type = getIntent().getStringExtra("type");
        }

        if (TextUtils.equals(type, "2")) {
            initDatas();
        } else if (TextUtils.equals(type, "1")) {
            initMonthData();

        }
        mBinding.llRepaymentPlan.setOnClickListener(v -> {
            if (mdata != null) RepaymentPlanActivity.open(CarLoanDetailsActivity.this, mdata);
        });
        mBinding.btnEarlyRepayment.setOnClickListener(v -> {
        });

    }
    private void initMonthData(){
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarLoanDetailsMonthActivity("630541", StringUtils.getJsonToString(map));
        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<CarLoanDetailsActivityMonthBean>(this) {
            @Override
            protected void onSuccess(CarLoanDetailsActivityMonthBean data, String SucMessage) {
//这个不需要跳转  所以数据不用传递

                if (TextUtils.equals("1",type)){
                    mBinding.tvTypeMoney.setText("应还总额");
                    mBinding.llTime.setVerticalGravity(View.VISIBLE);
                    mBinding.llRepaymentPlan.setVisibility(View.GONE);
                    mBinding.btnEarlyRepayment.setVisibility(View.GONE);
                }
                mBinding.tvBeForOver.setText(MoneyUtils.showPriceDouble(data.getRepayCapital()));//这个先设置为本期本金
                if (TextUtils.equals(data.getRepayBiz().getRefType(),"0")){
                mBinding.tvLoanCar.setText("车辆贷款");//贷款车辆
                }else{
                mBinding.tvLoanCar.setText("商品贷");
                }

                mBinding.tvLoanTotal.setText(MoneyUtils.showPriceDouble(data.getPayedAmount()+data.getOverplusAmount()));//贷款总额
                mBinding.tvLoanTerm.setText(data.getRepayBiz().getLoanEndDatetime());//贷款期限
                mBinding.tvRepaymentPlan.setText(data.getBankcardNumber());//还款卡号
//
                if (TextUtils.equals(data.getStatus(),"0")) {
                    mBinding.tvLoanType.setText("还款中");//还款状态
                }else{
                    mBinding.tvLoanType.setText("其他");
                }
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarLoanDetailsActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });

    }



    private void initDatas() {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarLoanDetailsActivity("630521", StringUtils.getJsonToString(map));
        addCall(call);
        showLoadingDialog();
        call.enqueue(new BaseResponseModelCallBack<CarLoanDetailsActivityBean>(this) {
            @Override
            protected void onSuccess(CarLoanDetailsActivityBean data, String SucMessage) {
                mdata = data;
                mBinding.tvBeForOver.setText(MoneyUtils.showPriceDouble(data.getRestAmount()));
                mBinding.tvLoanCar.setText(MoneyUtils.showPriceDouble(data.getRestAmount()));//贷款车辆
                mBinding.tvLoanTotal.setText(MoneyUtils.showPriceDouble(data.getLoanAmount()));//贷款总额
                mBinding.tvLoanTerm.setText(data.getLoanEndDatetime());//贷款期限
                mBinding.tvRepaymentPlan.setText(data.getLoanOrder().getBankcardNumber());//还款卡号

                if (TextUtils.equals(data.getStatus(),"0")) {
                    mBinding.tvLoanType.setText("还款中");//还款状态
                }
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarLoanDetailsActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });
    }
}
