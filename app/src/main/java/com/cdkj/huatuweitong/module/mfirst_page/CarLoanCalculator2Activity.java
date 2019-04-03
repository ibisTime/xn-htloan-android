package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.SystemKeyDataBean;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.baselibrary.utils.ToastUtil;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarLoanCalculatorBean;
import com.cdkj.huatuweitong.bean.CarModelActivityBean;
import com.cdkj.huatuweitong.databinding.CarLoanCalculator2Binding;
import com.cdkj.huatuweitong.utlis.DataHelper;

import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 车贷计算器
 */
public class CarLoanCalculator2Activity extends AbsBaseLoadActivity {

    private CarLoanCalculator2Binding mBinding;
    private CarModelActivityBean.CarsBean carModelActivityBean;
    private String[] ratSingData;//还款期数  获取系统参数
    private List<SystemKeyDataBean.ListBean> ratSingList;
    private int checkRatItem = -1;
    private String isTotal = "1";//1 全款 0 贷款

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, CarLoanCalculator2Activity.class);
            context.startActivity(intent);
        }
    }

    public static void open(Context context, CarModelActivityBean.CarsBean data) {
        if (context != null) {
            Intent intent = new Intent(context, CarLoanCalculator2Activity.class);
            //上页数据
            intent.putExtra("data", data);
            intent.putExtra("type", 1);
            context.startActivity(intent);
        }
    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.car_loan_calculator2, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        setShowTitle(false);
        getSysteamRat();
        init();
        initOnclick();
    }

    /**
     * 初始化数据
     */
    private void init() {
        if (getIntent() != null) {
            carModelActivityBean = (CarModelActivityBean.CarsBean) getIntent().getSerializableExtra("data");
            if (carModelActivityBean != null) {
                mBinding.tvBrand.setText(carModelActivityBean.getBrandName() + carModelActivityBean.getSeriesName() + carModelActivityBean.getName());//车型
                mBinding.tvAllModel.setText(carModelActivityBean.getSalePrice() + "");
                setViewData();
            }
        }
    }


    private void initOnclick() {
        mBinding.ivBack.setOnClickListener(v -> {
            finish();
        });

        mBinding.btnLeft.setOnClickListener(v -> {
            mBinding.btnLeft.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBinding.btnLeft.setBackgroundResource(R.drawable.bg_left_round_white);
            mBinding.btnRight.setTextColor(getResources().getColor(R.color.white));
            mBinding.btnRight.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBinding.llPayMsg.setVisibility(View.GONE);
            mBinding.llControlYear.setVisibility(View.GONE);
            mBinding.llOnePay.setVisibility(View.GONE);
            mBinding.tvTitle.setText("预计总花费(裸车价格+必要花费+商业保险)");
            isTotal = "1";
            setViewData();
        });

        mBinding.btnRight.setOnClickListener(v -> {
            mBinding.btnRight.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBinding.btnRight.setBackgroundResource(R.drawable.bg_right_round_white);
            mBinding.btnLeft.setTextColor(getResources().getColor(R.color.white));
            mBinding.btnLeft.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBinding.llPayMsg.setVisibility(View.VISIBLE);
            mBinding.llControlYear.setVisibility(View.VISIBLE);
            mBinding.llOnePay.setVisibility(View.VISIBLE);
            mBinding.tvTitle.setText("预计首付款(裸车价格+必要花费+商业保险)");
            isTotal = "0";
            setViewData();
        });

        mBinding.llBrand.setOnClickListener(v -> CarBrandActivity.open(CarLoanCalculator2Activity.this, true));

        mBinding.llControlYear.setOnClickListener(v -> {
            if (carModelActivityBean != null) {
                showRateSingleDialog();
            } else {
                ToastUtil.show(this, "请先选择品牌数据");
            }
        });
    }

    /**
     * 获取利率
     */
    private void getSysteamRat() {
        DataHelper.getSystemType(this, "car_periods", list -> {

            if (list != null && list.size() > 0) {
                ratSingList = list;
                ratSingData = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    ratSingData[i] = list.get(i).getCkey() + "期";
                }
            }
        });
    }

    private void showRateSingleDialog() {
        //如果提交按钮不显示了  说明已经申请过了  就不能再进行选择了

        if (ratSingData == null && ratSingData.length == 0) {
            UITipDialog.showInfo(this, "暂无可选期数");
            return;
        }
        AlertDialog ad = new AlertDialog.Builder(CarLoanCalculator2Activity.this).setTitle("选择还款期数")
                .setSingleChoiceItems(ratSingData, checkRatItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkRatItem = which;
                        mBinding.tvControlYear.setText(ratSingData[which]);
//                        mBinding.tvOnePayLilv.setText(ratSingList.get(which).getCvalue());
                        setViewData();
                        dialog.dismiss();
                    }
                }).create();
        ad.show();
    }

    private void setViewData() {
        if (carModelActivityBean == null) {
            return;
        }
        //如果是选择贷款  但是没选期数 也不请求数据
        if (TextUtils.equals("0", isTotal) && checkRatItem < 0) {
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("carCode", carModelActivityBean.getCode());
        map.put("isTotal", isTotal);
        if (checkRatItem < 0) {
            map.put("period", "12");
        } else {
            map.put("period", ratSingList.get(checkRatItem).getCkey());
        }

        Call<BaseResponseModel<CarLoanCalculatorBean>> carLoanCalculator = RetrofitUtils.createApi(MyApiServer.class).getCarLoanCalculator("630428", StringUtils.getJsonToString(map));
        showLoadingDialog();
        carLoanCalculator.enqueue(new BaseResponseModelCallBack<CarLoanCalculatorBean>(this) {
            @Override
            protected void onSuccess(CarLoanCalculatorBean data, String SucMessage) {

                if (TextUtils.equals("1", isTotal)) {
                    mBinding.tvMoney.setText(data.getTotalAmount() + "");
                    mBinding.tvBiyaoMoney.setText(data.getByhf() + "");
                    mBinding.tvBiyaoMoney2.setText(data.getByhf() + "");
                } else {
                    mBinding.tvMoney.setText(data.getYjsfAmount() + "");
                    mBinding.tvAllModel.setText(data.getSaleAmount() + "");
                    mBinding.tvOnePayLilv.setText(data.getYjsfAmount() + "");
                    mBinding.tvMonthlySupply.setText(data.getMonthReply() + "");
                    mBinding.tvManyMoney.setText(data.getExtraAmount() + "");
                    mBinding.tvToatlMoney.setText(data.getTotalAmount() + "");
                    mBinding.tvBiyaoMoney.setText(data.getByhf() + "");
                    mBinding.tvBiyaoMoney2.setText(data.getByhf() + "");
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    /**
     * 接受车型数据
     *
     * @param bean
     */
    @Subscribe
    public void breakCarModelActivityBean(CarModelActivityBean.CarsBean bean) {
        this.carModelActivityBean = bean;
        mBinding.tvBrand.setText(bean.getBrandName() + bean.getSeriesName() + bean.getName());//车型
        mBinding.tvAllModel.setText(bean.getSalePrice() + "");
        setViewData();
    }
}
