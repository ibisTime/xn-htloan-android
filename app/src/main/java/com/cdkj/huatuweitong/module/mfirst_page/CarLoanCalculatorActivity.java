package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.IntroductionInfoModel;
import com.cdkj.baselibrary.model.SystemKeyDataBean;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarBrandActivityBean;
import com.cdkj.huatuweitong.bean.CarDetailsBean;
import com.cdkj.huatuweitong.bean.CarLoanCalculatorActivityDetailsBean;
import com.cdkj.huatuweitong.bean.CarLoanCalculatorSendBean;
import com.cdkj.huatuweitong.bean.CarModelActivityBean;
import com.cdkj.huatuweitong.databinding.CarLoanCalculatorBinding;
import com.cdkj.huatuweitong.module.user.MyCarLoanActivity;
import com.cdkj.huatuweitong.utlis.DataHelper;

import org.greenrobot.eventbus.Subscribe;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 车贷计算器
 */
public class CarLoanCalculatorActivity extends AbsBaseLoadActivity {

    private CarLoanCalculatorBinding mBinding;
    private int type;//0代表是从首页直接进入的  1  代表是 从申请车贷的时候进入的  2代表是从我的车贷申请进入的

    private CarDetailsBean currentdata;
    private List<SystemKeyDataBean.ListBean> ratSingList;
    private String[] ratSingData;//还款期数  获取系统参数
    private String[] paySingData = new String[]{"30%", "50%", "70%"};

    private int repayments;//还款期数
    private double downPayments = 0.3;//首付默认是30%
    private double rate;//利率
    private String code;//从我的车贷详情跳转过来的
    private BigDecimal salePrice = new BigDecimal(0);

    private int checkRatItem = 0;//上次选中的 期数
    private int checkPayItem = 0;//上次选中的  首付

    private CarBrandActivityBean carBrandActivityBean;//车的品牌
    private CarModelActivityBean carModelActivityBean;//车型


    public static void open(Context context, int type) {
        if (context != null) {
            Intent intent = new Intent(context, CarLoanCalculatorActivity.class);
            intent.putExtra("type", type);
            context.startActivity(intent);
        }
    }

    public static void open(Context context, CarDetailsBean data) {
        if (context != null) {
            Intent intent = new Intent(context, CarLoanCalculatorActivity.class);
            //上页数据
            intent.putExtra("data", data);
            intent.putExtra("type", 1);
            context.startActivity(intent);
        }
    }

    public static void open(Context context, String code) {
        if (context != null) {
            Intent intent = new Intent(context, CarLoanCalculatorActivity.class);
            intent.putExtra("code", code);
            intent.putExtra("type", 2);
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
            type = getIntent().getIntExtra("type", 0);
            if (type == 1) {
                currentdata = (CarDetailsBean) getIntent().getSerializableExtra("data");
            } else if (type == 2) {
                code = getIntent().getStringExtra("code");
            }
        }
        initOnclick();
        //先给利率和首付一个默认值
        downPayments = 0.3;//首付
        mBinding.tvOnePay.setText("30%");

        if (type == 0) {
            //从首页跳转过来的  去获取利率和期数
            getSysteamRat();

        } else if (type == 1) {
            //从首页点击 推荐车型  申请购买  进来的
            getSysteamRat();
            //去计算利息等等
            salePrice = currentdata.getSalePrice();

            mBinding.tvModel.setText(currentdata.getName());//名字
            mBinding.tvBrand.setText(currentdata.getSeriesName());//品牌名字

            mBinding.ivModel.setVisibility(View.GONE);
            mBinding.ivBrand.setVisibility(View.GONE);

        } else if (type == 2) {
            // 从我的车贷申请跳转过来 去联网请求数据  通过参数code
            setRightShow(View.GONE);
            getInitDataDetails();
        }

    }

    /**
     * 获取利率
     */
    private void getSysteamRat() {
        DataHelper.getSystemKey(this, "car_periods", list -> {
            if (list != null && list.size() > 0) {

                rate = Double.parseDouble(list.get(0).getCvalue()) / 100;
                repayments = Integer.parseInt(list.get(0).getCkey());
                ratSingList = list;
                ratSingData = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    ratSingData[i] = list.get(i).getCkey() + "期";
                }
                mBinding.tvControlYear.setText(ratSingData[0]);
                mBinding.tvRato.setText(list.get(0).getCvalue());

                if (type == 1) {
                    setViewData();
                }
            }
        });
    }

    private void initOnclick() {
        if (type == 0) {
            mBinding.llBrand.setOnClickListener(v -> CarBrandActivity.open(CarLoanCalculatorActivity.this));
            mBinding.llModel.setOnClickListener(v -> {
                if (carBrandActivityBean == null) {
                    UITipDialog.showInfo(CarLoanCalculatorActivity.this, "请先选择品牌");
                    return;
                }
                CarSystemActivity.open(CarLoanCalculatorActivity.this, carBrandActivityBean);

            });
            mBinding.llOnePay.setOnClickListener(v -> showPaySingleDialog());
            mBinding.llControlYear.setOnClickListener(v -> showRateSingleDialog());
            mBinding.tvPayCar.setOnClickListener(v -> {
                if (carModelActivityBean == null) {
                    UITipDialog.showInfo(CarLoanCalculatorActivity.this, "请选择车型");
                    return;
                }
                sendRegist0();
            });


        } else if (type == 1) {
            mBinding.llOnePay.setOnClickListener(v -> showPaySingleDialog());
            mBinding.llControlYear.setOnClickListener(v -> showRateSingleDialog());
            mBinding.tvPayCar.setOnClickListener(v -> sendRegist1());

        } else if (type == 2) {
            //中间的按钮全部不能点击  也不能提交申请  因为已经申请过了
            mBinding.tvPayCar.setVisibility(View.GONE);
        }
    }

    public void getInitDataDetails() {

        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        showLoadingDialog();
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarLoanCalculatorActivityDetails("630437", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<CarLoanCalculatorActivityDetailsBean>(this) {
            @Override
            protected void onSuccess(CarLoanCalculatorActivityDetailsBean data, String SucMessage) {

                //获取数据设置到文本上
                salePrice = new BigDecimal(data.getPrice());
                mBinding.tvMoney.setText(MoneyUtils.showPriceDouble(data.getPrice()));
                mBinding.tvDowanPayments.setText(MoneyUtils.showPriceDouble(data.getSfAmount()));

                mBinding.tvModel.setText(data.getCarName());//车型
                mBinding.tvBrand.setText(data.getSeriesName());//品牌
                mBinding.tvOnePay.setText((data.getSfRate() * 100) + "%");//首付
                mBinding.tvControlYear.setText((int) data.getPeriods() + "");//还款期数
                mBinding.tvRato.setText(data.getSfRate() + "");
                downPayments = data.getSfRate();
                rate = data.getSfRate();
                repayments = (int) data.getPeriods();
                //去计算并设置值
                setViewData();
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarLoanCalculatorActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });

    }


    private void sendRegist0() {

        if (!SPUtilHelper.isLogin(this, false)) {
            return;
        }
        Map<String, Object> map = new HashMap();
        map.put("brandCode", carModelActivityBean.getBrandCode());//品牌编号
        map.put("brandName", carModelActivityBean.getBrandName());//品牌名
        map.put("seriesCode", carModelActivityBean.getSeriesCode());//车系
        map.put("seriesName", carModelActivityBean.getSeriesName());//车系
        map.put("carCode", carModelActivityBean.getCode());//车型编号
        map.put("carName", carModelActivityBean.getName());//车型名
        String format = DateUtil.format(new Date());
        map.put("createDatetime", format);
        map.put("periods", String.valueOf(repayments));


        map.put("price", salePrice.longValue());
        map.put("remark", "");
        map.put("saleDesc", "1");

        long shoufu = (long) Double.parseDouble(mBinding.tvDowanPayments.getText().toString()) * 1000;//将金额变成厘传递
        map.put("sfAmount", shoufu + "");
        map.put("sfRate", rate + "");
        map.put("userId", SPUtilHelper.getUserId());
        map.put("userMobile", SPUtilHelper.getUserPhoneNum());

        subMitRequestOrder(map);
    }


    private void sendRegist1() {

        if (!SPUtilHelper.isLogin(this, false)) {
            return;
        }

        Map<String, Object> map = new HashMap();
        map.put("brandCode", currentdata.getBrandCode());
        map.put("brandName", currentdata.getBrandName());
        map.put("carCode", currentdata.getCode());
        map.put("carName", currentdata.getName());
        String format = DateUtil.format(new Date());
        map.put("createDatetime", format);
        map.put("periods", String.valueOf(repayments));
        long price = (long) salePrice.doubleValue();
        map.put("price", price);
        map.put("remark", "");
        map.put("saleDesc", createSaleDesc());
        map.put("seriesCode", currentdata.getCode());
        map.put("seriesName", currentdata.getSeriesName());
        long shoufu = (long) Double.parseDouble(mBinding.tvDowanPayments.getText().toString()) * 1000;//将金额变成厘传递
        map.put("sfAmount", shoufu + "");
        map.put("sfRate", downPayments + "");
        map.put("userId", SPUtilHelper.getUserId());
        map.put("userMobile", SPUtilHelper.getUserPhoneNum());

        subMitRequestOrder(map);
    }

    /**
     * @return
     */
    private String createSaleDesc() {
        String saleDesc = "首付" + mBinding.tvDowanPayments.getText().toString() + "元,"
                + "月供" + mBinding.tvMonthlySupply.getText().toString() + "元,"
                + "多花" + mBinding.tvManyMoney.getText().toString() + "元";

        return saleDesc;
    }

    private void subMitRequestOrder(Map map) {
        Call call = RetrofitUtils.createApi(MyApiServer.class).sendCarLoanCalculator("630430", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<CarLoanCalculatorSendBean>(CarLoanCalculatorActivity.this) {
            @Override
            protected void onSuccess(CarLoanCalculatorSendBean data, String SucMessage) {
                UITipDialog.showInfo(CarLoanCalculatorActivity.this, "申请成功");
                mBinding.tvPayCar.setVisibility(View.GONE);
                setRightShow(View.GONE);
                MyCarLoanActivity.open(CarLoanCalculatorActivity.this);
                finish();
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

        BigDecimal cankaojia = salePrice;//总价
        BigDecimal shoufu = MoneyUtils.bigDecimalRide(cankaojia, downPayments);//首付款
        BigDecimal daikuane = cankaojia.subtract(shoufu);//贷款额   被减数  减数
        BigDecimal shouxufei = daikuane.multiply(new BigDecimal(rate));//手续费总额
        BigDecimal daikuanzonge = daikuane.add(shouxufei);//贷款总额
        BigDecimal yuegong = daikuanzonge.divide(new BigDecimal(repayments), 3);//月供
        BigDecimal duohua = yuegong.multiply(new BigDecimal(repayments)).add(shoufu).subtract(cankaojia);
        mBinding.tvDowanPayments.setText(MoneyUtils.showPrice(shoufu));
        mBinding.tvMonthlySupply.setText(MoneyUtils.showPrice(yuegong));
        mBinding.tvManyMoney.setText(MoneyUtils.showPrice(duohua));
        mBinding.tvMoney.setText(MoneyUtils.showPrice(cankaojia));

    }


    private void showPaySingleDialog() {
        //如果提交按钮不显示了  说明已经申请过了  就不能再进行选择了
        if (mBinding.tvPayCar.getVisibility() != View.VISIBLE) {
            return;
        }

        AlertDialog ad = new AlertDialog.Builder(CarLoanCalculatorActivity.this).setTitle("选择首付比")
                .setSingleChoiceItems(paySingData, checkPayItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkPayItem = which;
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
        //如果提交按钮不显示了  说明已经申请过了  就不能再进行选择了

        if (mBinding.tvPayCar.getVisibility() != View.VISIBLE) {
            return;
        }
        if (ratSingData == null && ratSingData.length == 0) {
            UITipDialog.showInfo(this, "暂无可选期数");
            return;

        }
        AlertDialog ad = new AlertDialog.Builder(CarLoanCalculatorActivity.this).setTitle("选择还款期数")
                .setSingleChoiceItems(ratSingData, checkRatItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkRatItem = which;

                        rate = Double.parseDouble(ratSingList.get(checkRatItem).getCvalue()) / 100;
                        repayments = Integer.parseInt(ratSingList.get(checkRatItem).getCkey());
                        mBinding.tvControlYear.setText(ratSingData[which]);
                        mBinding.tvRato.setText(ratSingList.get(which).getCvalue());
                        setViewData();
                        dialog.dismiss();
                    }
                }).create();
        ad.show();
    }

    /**
     * 获取系统参数   利率和首付  暂没找到接口
     */
    public void getKeyUrl() {

        Map<String, String> map = new HashMap<>();
        map.put("ckey", "car_periods");
        map.put("systemCode", MyCdConfig.SYSTEM_CODE);
        map.put("companyCode", MyCdConfig.COMPANY_CODE);

        Call call = RetrofitUtils.getBaseAPiService().getKeySystemInfo("805917", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<IntroductionInfoModel>(this) {
            @Override
            protected void onSuccess(IntroductionInfoModel data, String SucMessage) {
                if (TextUtils.isEmpty(data.getCvalue())) {
                    return;
                }
                // mBinding.tvAmount.setText(MoneyUtils.MONEYSING+data.getCvalue());
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(CarLoanCalculatorActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    private void setRightShow(int isShow) {
        mBinding.ivOnePay.setVisibility(isShow);
        mBinding.ivModel.setVisibility(isShow);
        mBinding.ivBrand.setVisibility(isShow);
        mBinding.ivControlYear.setVisibility(isShow);

    }

    /**
     * 接受品牌数据
     *
     * @param bean
     */
    @Subscribe
    public void breakCarBrandActivityBean(CarBrandActivityBean bean) {
        this.carBrandActivityBean = bean;
        mBinding.tvBrand.setText(bean.getName());//品牌

        carModelActivityBean = null;
        mBinding.tvModel.setText("");//车型

    }

    /**
     * 接受车型数据
     *
     * @param bean
     */
    @Subscribe
    public void breakCarModelActivityBean(CarModelActivityBean bean) {
        this.carModelActivityBean = bean;
        mBinding.tvModel.setText(bean.getName());//车型
        salePrice = bean.getSalePrice();
        setViewData();
    }

}
