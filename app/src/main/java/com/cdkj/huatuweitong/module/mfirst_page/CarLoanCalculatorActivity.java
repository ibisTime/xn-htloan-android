package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarDetailsBean;
import com.cdkj.huatuweitong.bean.CarLoanCalculatorSendBean;
import com.cdkj.huatuweitong.databinding.CarLoanCalculatorBinding;
import com.cdkj.huatuweitong.utlis.MoneyUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 车贷计算器
 */
public class CarLoanCalculatorActivity extends AbsBaseLoadActivity {

    private CarLoanCalculatorBinding mBinding;
    private String salePrice = "0";

    private CarDetailsBean currentdata;
    String[] ratSingData = new String[]{"1年", "2年", "3年"};
    String[] paySingData = new String[]{"30%", "50%", "70%"};

    private int repayments = 1;//还款年限默认是一年
    private double downPayments = 0.3;//首付默认是30%
    private double rate = 0.1;//利率默认是0.1  利率和还款年限有关

    public static void open(Context context) {
//        startActivity();
        if (context != null) {
            Intent intent = new Intent(context, CarLoanCalculatorActivity.class);
            context.startActivity(intent);
        }

    }

    public static void open(Context context, CarDetailsBean data) {
//        startActivity();
        if (context != null) {
            Intent intent = new Intent(context, CarLoanCalculatorActivity.class);
            //上页数据
            intent.putExtra("data", data);


            context.startActivity(intent);
        }

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.car_loan_calculator, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.car_calculator_title));
        if (getIntent() != null) {
            currentdata = (CarDetailsBean) getIntent().getSerializableExtra("data");
        }

        initOnclick();

        setViewData();
        String s = new BigDecimal("3.00").toPlainString();
        Log.i("ppppp", "afterCreate: "+s);

    }

    private void sendRegist() {
        //        brandCode	品牌编号（必填）	string
//        brandName	品牌名称（必填）	string
//        carCode	车型编号（必填）	string
//        carName	车型名称（必填）	string
//        createDatetime	申请时间（必填）	string
//        periods	分期期数（必填）	string
//        price	车辆总价（必填）	string
//        remark	备注（选填）	string
//        saleDesc	计算器信息（必填）	string
//        seriesCode	车系编号（必填）	string
//        seriesName	车系名称（必填）	string
//        sfAmount	首付金额（必填）	string
//        sfRate	首付比例（必填）	string
//        userId	申请人编号（必填）	string
//        userMobile	申请人手机号（必填）

        Map map = new HashMap<String, String>();
        map.put("brandCode", currentdata.getBrandCode());
        map.put("brandName", currentdata.getBrandName());
        map.put("carCode", currentdata.getCode());
        map.put("carName", currentdata.getName());
        String format = DateUtil.format(new Date());
        Log.i("pppppp", "afterCreate: " + format);
        map.put("createDatetime", format);
        map.put("periods", String.valueOf(repayments));
        long price = (long) currentdata.getSalePrice().doubleValue() * 1000;
        map.put("price", price);
        map.put("remark", "我是备注");
        map.put("saleDesc", "1");
        map.put("seriesCode", currentdata.getCode());
        map.put("seriesName", currentdata.getSeriesName());
        long shoufu = (long) Double.parseDouble(mBinding.tvDowanPayments.getText().toString()) * 1000;//将金额变成厘传递
        map.put("sfAmount", shoufu + "");
        map.put("sfRate", rate + "");
        map.put("userId", SPUtilHelpr.getUserId());
        map.put("userMobile", SPUtilHelpr.getUserPhoneNum());

        Call call = RetrofitUtils.createApi(MyApiServer.class).sendCarLoanCalculator("630430", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<CarLoanCalculatorSendBean>(CarLoanCalculatorActivity.this) {
            @Override
            protected void onSuccess(CarLoanCalculatorSendBean data, String SucMessage) {
                UITipDialog.showInfo(CarLoanCalculatorActivity.this, "申请成功");
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarLoanCalculatorActivity.this, errorCode);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });
    }

    private void setViewData() {

        BigDecimal cankaojia = currentdata.getSalePrice();//总价
        BigDecimal shoufu = MoneyUtils.bigDecimalRide(cankaojia, downPayments);//首付款
        BigDecimal daikuane = cankaojia.subtract(shoufu);//贷款额   被减数  减数
        BigDecimal shouxufei = daikuane.multiply(new BigDecimal(rate));//手续费总额
        BigDecimal daikuanzonge = daikuane.add(shouxufei);//贷款总额

        Log.i("ppppp", "setViewData: 贷款总额:" + daikuanzonge + "月供:" + repayments * 12);
        BigDecimal yuegong = daikuanzonge.divide(new BigDecimal(repayments * 12), 3);//月供
        BigDecimal duohua = yuegong.multiply(new BigDecimal(repayments * 12)).add(shoufu).subtract(cankaojia);

        mBinding.tvDowanPayments.setText(MoneyUtils.BigDecimalToString2(shoufu));
        mBinding.tvMonthlySupply.setText(MoneyUtils.BigDecimalToString2(yuegong));
        mBinding.tvManyMoney.setText(MoneyUtils.BigDecimalToString2(duohua));
        mBinding.tvMoney.setText(MoneyUtils.BigDecimalToString2(cankaojia));
        mBinding.tvModel.setText(currentdata.getName());//名字
        mBinding.tvBrand.setText(currentdata.getSeriesName());//品牌名字

    }

    private void initOnclick() {
        mBinding.llOnePay.setOnClickListener(v -> showPaySingleDialog());
        mBinding.llControlYear.setOnClickListener(v -> showRateSingleDialog());
        mBinding.tvPayCar.setOnClickListener(v -> sendRegist());
    }

    private void showPaySingleDialog() {

        AlertDialog ad = new AlertDialog.Builder(CarLoanCalculatorActivity.this).setTitle("选择首付比")
                .setSingleChoiceItems(paySingData, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                downPayments = 0.3;
                                break;
                            case 1:
                                downPayments = 0.5;
                                break;
                            case 2:
                                downPayments = 0.7;
                                break;
                        }
                        mBinding.tvOnePay.setText(paySingData[which]);
                        setViewData();
                        dialog.dismiss();

                    }
                }).create();
        ad.show();
    }

    private void showRateSingleDialog() {

        AlertDialog ad = new AlertDialog.Builder(CarLoanCalculatorActivity.this).setTitle("选择还款年限")
                .setSingleChoiceItems(ratSingData, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                rate = 0.1;
                                repayments = 1;
                                break;
                            case 1:
                                rate = 0.2;
                                repayments = 2;
                                break;
                            case 2:
                                rate = 0.3;
                                repayments = 3;
                                break;
                        }
                        mBinding.tvControlYear.setText(ratSingData[which]);
                        setViewData();
                        dialog.dismiss();
                    }
                }).create();
        ad.show();
    }
}
