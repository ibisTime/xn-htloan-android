package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.bumptech.glide.repackaged.com.google.common.base.Strings;
import com.cdkj.baselibrary.activitys.BankCardListActivity;
import com.cdkj.baselibrary.activitys.address.AddressListActivity;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.AddressModel;
import com.cdkj.baselibrary.model.BankCardModel;
import com.cdkj.baselibrary.model.CodeModel;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.BigDecimalUtils;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.OrderSubmitIntentBean;
import com.cdkj.huatuweitong.databinding.ActivityOrderSubmitBinding;

import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 提交订单
 */
public class OrderSubmitActivity extends AbsBaseLoadActivity {

    private ActivityOrderSubmitBinding mBinding;

    private OrderSubmitIntentBean orderSubmitIntentBean;

    private AddressModel mSelectAddress;//用户选择的地址
    private BankCardModel mBankCardModel;//用户选择的银行卡


    /**
     * @param context
     * @param orderSubmitIntentBean
     */
    public static void open(Context context, OrderSubmitIntentBean orderSubmitIntentBean) {
        if (context != null) {
            Intent intent = new Intent(context, OrderSubmitActivity.class);
            intent.putExtra(CdRouteHelper.DATASIGN, orderSubmitIntentBean);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_order_submit, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.OrderSubmit));

        if (getIntent() != null) {
            orderSubmitIntentBean = getIntent().getParcelableExtra(CdRouteHelper.DATASIGN);
        }


        mBinding.tvReceiveAddress.setText("请选择收货地址");

        setShowData(orderSubmitIntentBean);

        initOclick();
    }

    /**
     * 设置显示数据
     *
     * @param orderSubmitIntentBean
     */
    private void setShowData(OrderSubmitIntentBean orderSubmitIntentBean) {
        if (orderSubmitIntentBean == null) return;

        mBinding.tvName.setText(orderSubmitIntentBean.getProductName());

        mBinding.tvSpec.setText(orderSubmitIntentBean.getSpecBean().getName());

        mBinding.tvTotlePrice.setText(MoneyUtils.showPrice(orderSubmitIntentBean.getPrice()));

        mBinding.tvOnePayBili.setText(orderSubmitIntentBean.getSpecBean().getSfRate() * 100 + "%");

        mBinding.tvMonthlyNumber.setText(orderSubmitIntentBean.getSpecBean().getPeriods() + "");

        mBinding.tvMonthlyRate.setText(orderSubmitIntentBean.getSpecBean().getBankRate() * 100 + "%");

        mBinding.tvMonthlyPay.setText(MoneyUtils.showPrice(orderSubmitIntentBean.getSpecBean().getMonthAmount()));

        mBinding.tvOnePayMoney.setText(MoneyUtils.showPrice(com.cdkj.huatuweitong.utlis.MoneyUtils.bigDecimalRide(orderSubmitIntentBean.getPrice(), orderSubmitIntentBean.getSpecBean().getSfRate())));

        ImgUtils.loadQiniuImg(this, orderSubmitIntentBean.getProductPic(), mBinding.imgProduct);

        mBinding.tvNeedPay.setText(MoneyUtils.showPrice(com.cdkj.huatuweitong.utlis.MoneyUtils.bigDecimalRide(orderSubmitIntentBean.getPrice(), orderSubmitIntentBean.getSpecBean().getSfRate())));

    }

    private void initOclick() {
        mBinding.tvSendPay.setOnClickListener(v -> {
            if (mSelectAddress == null) {
                UITipDialog.showInfo(OrderSubmitActivity.this, "请先选择收货地址");
                return;
            }

            if (mBankCardModel == null) {
                UITipDialog.showInfo(OrderSubmitActivity.this, "请先选择绑定银行卡");
                return;
            }
            orderSubmit();

        });
        /*地址选择*/
        mBinding.linLayoutAddress.setOnClickListener(v -> {
            if (!SPUtilHelpr.isLogin(this, false)) {
                return;
            }
            AddressListActivity.open(this, true);
        });

        mBinding.linLayoutAddressSelect.setOnClickListener(v -> {
            if (!SPUtilHelpr.isLogin(this, false)) {
                return;
            }
            AddressListActivity.open(this, true);
        });
        /*银行卡选择*/

        mBinding.linLayoutBankcard.setOnClickListener(v -> {
            BankCardListActivity.open(this, true);
        });
    }


    /**
     * 订单提交
     */
    public void orderSubmit() {

        Map<String, String> map = new HashMap<>();

        map.put("applyUser", SPUtilHelpr.getUserId());

        map.put("productSpecsCode", orderSubmitIntentBean.getSpecBean().getCode());
        map.put("quantity", "1");
        map.put("reAddress", getDetailsAddress(mSelectAddress));
        map.put("reMobile", mSelectAddress.getMobile());
        map.put("receiver", mSelectAddress.getAddressee());
        map.put("bankcardCode", mBankCardModel.getCode());

        Call<BaseResponseModel<String>> call = RetrofitUtils.getBaseAPiService().stringRequest("808050", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<String>(this) {

            @Override
            protected void onSuccess(String data, String SucMessage) {
                UITipDialog.showSuccess(OrderSubmitActivity.this,"下单成功",dialog -> {
                    PayActivity.open(OrderSubmitActivity.this, data, mBinding.tvNeedPay.getText().toString(),false);
                    finish();
                });
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });


    }

    /**
     * 获取详情地址
     *
     * @param addressModel
     * @return
     */
    @NonNull
    private String getDetailsAddress(AddressModel addressModel) {
        if (addressModel == null) return "";
        return addressModel.getProvince() + " " + addressModel.getCity() + " " + addressModel.getArea() + "" + addressModel.getDetail();
    }


    /**
     * 接受用户选择的地址
     *
     * @param addressModel
     */
    @Subscribe
    public void addressSelect(AddressModel addressModel) {
        mSelectAddress = addressModel;
        mBinding.linLayoutAddress.setVisibility(View.VISIBLE);
        mBinding.linLayoutAddressSelect.setVisibility(View.GONE);
        mBinding.tvReceiveName.setText("收货人：" + addressModel.getAddressee());
        mBinding.tvReceiveNumber.setText(addressModel.getMobile());
        mBinding.tvReceiveAddress.setText("收货地址:" + getDetailsAddress(addressModel));
    }

    /**
     * 接受用户选择的银行卡
     *
     * @param bankCardModel
     */
    @Subscribe
    public void addressSelect(BankCardModel bankCardModel) {
        mBankCardModel = bankCardModel;
        mBinding.tvBankUser.setText("持卡人:" + bankCardModel.getRealName());
        mBinding.tvBankNumber.setText("卡号:" + bankCardModel.getBankcardNumber());
        mBinding.tvBankName.setText("开户行:" + bankCardModel.getBankName());

        mBinding.tvBankNumber.setVisibility(View.VISIBLE);
        mBinding.tvBankUser.setVisibility(View.VISIBLE);
        mBinding.tvBankName.setVisibility(View.VISIBLE);
    }


}
