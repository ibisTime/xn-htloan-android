package com.cdkj.huatuweitong.module.order;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.OrderBean;
import com.cdkj.huatuweitong.databinding.ActivityOrderDetailsBinding;
import com.cdkj.huatuweitong.other.OrderHelper;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * Created by cdkj on 2018/5/19.
 */

public class OrderDetailsActivity extends AbsBaseLoadActivity {

    private String orderCode;

    private ActivityOrderDetailsBinding mBinding;

    /**
     * @param context
     * @param orderCode 订单编号
     */
    public static void open(Context context, String orderCode) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, OrderDetailsActivity.class);
        intent.putExtra(CdRouteHelper.DATASIGN, orderCode);
        context.startActivity(intent);
    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_order_details, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        mBaseBinding.titleView.setMidTitle("订单详情");

        if (getIntent() != null) {
            orderCode = getIntent().getStringExtra(CdRouteHelper.DATASIGN);
        }

        getOrderDetails();
    }

    public void getOrderDetails() {

        if (TextUtils.isEmpty(orderCode)) return;

        Map<String, String> map = new HashMap<>();

        map.put("code", orderCode);

        Call<BaseResponseModel<OrderBean>> call = RetrofitUtils.createApi(MyApiServer.class).getOrderDetails("808066", StringUtils.getJsonToString(map));

        addCall(call);

        showLoadingDialog();

        call.enqueue(new BaseResponseModelCallBack<OrderBean>(this) {
            @Override
            protected void onSuccess(OrderBean data, String SucMessage) {
                setShowData(data);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    /**
     * @param data
     */
    private void setShowData(OrderBean data) {
        if (data == null) return;

        mBinding.tvCode.setText(data.getCode());
        mBinding.tvPayDate.setText(DateUtil.formatStringData(data.getApplyDatetime(), DateUtil.DATE_YMD));
        mBinding.tvOrderState.setText(OrderHelper.ORDER_STATE.fromTypeName(data.getStatus()));

        if (data.getProductOrderList() != null && data.getProductOrderList().size() > 0 && data.getProductOrderList().get(0).getProduct() != null) {
            mBinding.tvName.setText(data.getProductOrderList().get(0).getProduct().getName());
            mBinding.tvPrice.setText(MoneyUtils.showPrice(data.getProductOrderList().get(0).getPrice()));
            mBinding.tvSpec.setText(data.getProductOrderList().get(0).getProductSpecsName());
            ImgUtils.loadQiniuImg(this, data.getProductOrderList().get(0).getProduct().getAdvPic(), mBinding.imgTitle);
        }

    }


}
