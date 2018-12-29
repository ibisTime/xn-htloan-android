package com.cdkj.huatuweitong.module.reimbursement;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.activitys.ImageSelectActivity;
import com.cdkj.baselibrary.activitys.ShowBigPhotoActivity;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.CameraHelper;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.QiNiuHelper;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityBean;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityMonthBean;
import com.cdkj.huatuweitong.bean.ZXSuccessIDBean;
import com.cdkj.huatuweitong.databinding.ActivityCarLoanDetailsBinding;
import com.cdkj.huatuweitong.utlis.MyTextUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class CarLoanDetailsActivity extends AbsBaseLoadActivity {

    private ActivityCarLoanDetailsBinding mBinding;
    private String code;
    private String type;//1代表是 本月应还的   2代表是所有的贷款
    private CarLoanDetailsActivityBean mdata;
    private final int requestSuccess = 200;
    private String prepayPhotoUrl;

    public static void open(Context context, String code, String type) {
        if (context != null) {
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
            mBinding.tvTypeMoney.setText("剩余贷款");
        } else if (TextUtils.equals(type, "1")) {
            initMonthData();
            mBinding.tvTypeMoney.setText("应还总额");
            mBinding.llTime.setVerticalGravity(View.VISIBLE);
            mBinding.llButtom.setVisibility(View.GONE);
            mBinding.llRepaymentPlan.setVisibility(View.GONE);
            //只有商品才需要上传还款截图
            mBaseBinding.titleView.setRightTitle("还款照片");
            mBaseBinding.titleView.setRightFraClickListener(v -> {
                ImageSelectActivity.launch(CarLoanDetailsActivity.this, requestSuccess, false);
            });
            mBinding.ivImg.setOnClickListener(v -> {
                if (!TextUtils.isEmpty(prepayPhotoUrl)) {
                    ShowBigPhotoActivity.open(this, MyCdConfig.QINIUURL + prepayPhotoUrl);
                }
            });
//            ShowBigPhotoActivity
        }
        mBinding.llRepaymentPlan.setOnClickListener(v -> {
            if (mdata != null) RepaymentPlanActivity.open(CarLoanDetailsActivity.this, mdata);
        });


        mBinding.btnEarlyRepayment.setOnClickListener(v -> {
            String bankcardNumber;
            bankcardNumber = mdata.getBudgetOrder().getRepayBankcardNumber();
            AdvanceDetailsActivity.open(CarLoanDetailsActivity.this, mdata.getRestAmount() + "", bankcardNumber, mdata.getCode());

        });

    }

    private void initMonthData() {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarLoanDetailsMonthActivity("630541", StringUtils.getJsonToString(map));
        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<CarLoanDetailsActivityMonthBean>(this) {
            @Override
            protected void onSuccess(CarLoanDetailsActivityMonthBean data, String SucMessage) {

                //这个不需要跳转  所以数据不用传递
                mBinding.tvBeForOver.setText(MoneyUtils.showPriceDouble(data.getRepayCapital()));//这个先设置为本期本金
                //判断有没有返回预算单的信息 有的话就是从  oss走的还款数据  已预算单的为准  没有的话就是 从app上下单走的数据
                CarLoanDetailsActivityBean.BudgetOrderBean budgetOrder = data.getRepayBiz().getBudgetOrder();
                if (budgetOrder != null) {
                    if (TextUtils.equals(data.getRefType(), "1")) {
                        //商品贷
                        mBinding.tvType.setText("贷款商品");
                        mBinding.tvLoanCar.setText(data.getRepayBiz().getBudgetOrder().getProductOrderList().get(0).getProductName());
                        if (!TextUtils.isEmpty(data.getPrepayPhoto())) {
                            mBinding.ivImg.setVisibility(View.VISIBLE);
                            prepayPhotoUrl = data.getPrepayPhoto();
                            ImgUtils.loadQiniuImg(CarLoanDetailsActivity.this, data.getPrepayPhoto(), mBinding.ivImg);
                        }

                    } else if (TextUtils.equals(data.getRefType(), "0")) {
                        //车辆贷
                        mBinding.tvLoanCar.setText(data.getRepayBiz().getBudgetOrder().getCarBrand());
                        mBinding.tvType.setText("贷款车辆");
                    }
//                    mBinding.tvLoanCar.setText(budgetOrder.getCarBrand());
                    mBinding.tvLoanTotal.setText(MoneyUtils.showPriceDouble(data.getPayedAmount() + data.getOverplusAmount()));//贷款总额
                    mBinding.tvLoanTerm.setText(data.getPeriods() + "");//贷款期限
                    mBinding.tvRepaymentPlan.setText(data.getBankcardNumber());//还款卡号
                } else {
                    CarLoanDetailsActivityMonthBean.RepayBizBean.MallOrder mallOrder = data.getRepayBiz().getMallOrder();
                    if (mallOrder == null) {
                        return;
                    }
                    if (TextUtils.equals(data.getRefType(), "1")) {
                        //商品贷
                        mBinding.tvType.setText("贷款商品");
                        if (!TextUtils.isEmpty(data.getPrepayPhoto())) {
                            mBinding.ivImg.setVisibility(View.VISIBLE);
                            prepayPhotoUrl = data.getPrepayPhoto();
                            ImgUtils.loadQiniuImg(CarLoanDetailsActivity.this, data.getPrepayPhoto(), mBinding.ivImg);
                        }
                    } else if (TextUtils.equals(data.getRefType(), "0")) {
                        //车辆贷
                        mBinding.tvType.setText("贷款车辆");
                    }
                    mBinding.tvLoanCar.setText(mallOrder.getProductOrderList().get(0).getProduct().getName());
                    mBinding.tvLoanTotal.setText(MoneyUtils.showPriceDouble(data.getPayedAmount() + data.getOverplusAmount()));//贷款总额
                    mBinding.tvLoanTerm.setText(data.getPeriods() + "");//贷款期限
                    mBinding.tvRepaymentPlan.setText(mallOrder.getBankcardNumber());//还款卡号
                }

                MyTextUtils.setStatusTypeAll(mBinding.tvLoanType, data.getCurNodeCode());
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
                mBinding.tvBeForOver.setText(MoneyUtils.getShowPriceSign(data.getRestAmount()));

                if (data.getBudgetOrder() != null) {
                    //有预算单信息  有限取预算单的信息
                    setBudgetOrderView(data);
                } else {
                    setAppView(data);
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

    /**
     * 从oss端一步步审核通过的数据  取预算单的数据  getBudgetOrder
     *
     * @param data
     */
    private void setBudgetOrderView(CarLoanDetailsActivityBean data) {
        if (TextUtils.equals(data.getRefType(), "1")) {
            //商品贷
            mBinding.tvType.setText("贷款商品");
            mBinding.tvRepaymentPlan.setText(data.getBudgetOrder().getRepayBankcardNumber());//还款卡号

            if (data.getBudgetOrder().getProductOrderList() == null || data.getBudgetOrder().getProductOrderList().size() == 0)
                return;
            mBinding.tvLoanCar.setText(data.getBudgetOrder().getProductOrderList().get(0).getProductName());

        } else if (TextUtils.equals(data.getRefType(), "0")) {
            //车辆贷
            mBinding.tvLoanCar.setText(data.getBudgetOrder().getCarBrand());
            mBinding.tvType.setText("贷款车辆");
            mBinding.tvRepaymentPlan.setText(data.getBudgetOrder().getRepayBankcardNumber());//还款卡号
        }
        if (data.getBudgetOrder() != null) {
            mBinding.tvLoanCar.setText(data.getBudgetOrder().getCarBrand());
        }
        mBinding.tvLoanTotal.setText(MoneyUtils.showPriceDouble(data.getLoanAmount()));//贷款总额
        mBinding.tvLoanTerm.setText(data.getRepayPlanList().size() + "");//贷款期限

        MyTextUtils.setStatusTypeAll(mBinding.tvLoanType, data.getCurNodeCode());

    }

    /**
     * 从app端下单申请的商品
     *
     * @param data
     */
    private void setAppView(CarLoanDetailsActivityBean data) {
        if (TextUtils.equals(data.getRefType(), "1")) {
            //商品贷
            mBinding.tvType.setText("贷款商品");
            mBinding.tvRepaymentPlan.setText(data.getMallOrder() == null ? "" : data.getMallOrder().getBankcardNumber());//还款卡号
            if (data.getMallOrder().getProductOrderList() == null || data.getMallOrder().getProductOrderList().size() == 0)
                return;
            mBinding.tvLoanCar.setText(data.getMallOrder().getProductOrderList().get(0).getProduct().getName());

        } else if (TextUtils.equals(data.getRefType(), "0")) {
            //车辆贷
            mBinding.tvLoanCar.setText(data.getMallOrder().getProductOrderList().get(0).getProduct().getName());
            mBinding.tvType.setText("贷款车辆");
            mBinding.tvRepaymentPlan.setText(data.getMallOrder() == null ? "" : data.getMallOrder().getBankcardNumber());//还款卡号
        }

        mBinding.tvLoanTotal.setText(MoneyUtils.showPriceDouble(data.getLoanAmount()));//贷款总额
        mBinding.tvLoanTerm.setText(data.getRepayPlanList().size() + "");//贷款期限
        MyTextUtils.setStatusTypeAll(mBinding.tvLoanType, data.getCurNodeCode());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) {
            return;
        }
        if (requestCode == requestSuccess) {
            String path = data.getStringExtra(CameraHelper.staticPath);
            LogUtil.E("拍照获取路径" + path);
            showLoadingDialog();
            new QiNiuHelper(this).uploadSinglePic(new QiNiuHelper.QiNiuCallBack() {
                @Override
                public void onSuccess(String key) {
                    //加载图片,调取接口
                    disMissLoading();
                    mBinding.ivImg.setVisibility(View.VISIBLE);
                    prepayPhotoUrl = key;
                    ImgUtils.loadQiniuImg(CarLoanDetailsActivity.this, key, mBinding.ivImg);
                    upDataHKimg(key);
                }

                @Override
                public void onFal(String info) {
                    UITipDialog.showFall(CarLoanDetailsActivity.this, "照片上传失败");
                    disMissLoading();
                }
            }, path);
        }
    }


    private void upDataHKimg(String img) {
        Map map = new HashMap();
        map.put("code", code);
        map.put("operator", SPUtilHelper.getUserId());
        map.put("prepayPhoto", img);
        Call<BaseResponseModel<ZXSuccessIDBean>> baseResponseModelCall = RetrofitUtils.createApi(MyApiServer.class).upDataHKimg("630544", StringUtils.getJsonToString(map));
        showLoadingDialog();
        baseResponseModelCall.enqueue(new BaseResponseModelCallBack<ZXSuccessIDBean>(this) {
            @Override
            protected void onSuccess(ZXSuccessIDBean data, String SucMessage) {
                UITipDialog.showSuccess(CarLoanDetailsActivity.this, "上传成功");
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
