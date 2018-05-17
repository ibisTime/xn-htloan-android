package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.activitys.address.AddressListActivity;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.model.AddressModel;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityOrderSubmitBinding;

import org.greenrobot.eventbus.Subscribe;

/**
 * 提交订单
 */
public class OrderSubmitActivity extends AbsBaseLoadActivity {
    ActivityOrderSubmitBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, OrderSubmitActivity.class);
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
        initOclick();
    }

    private void initOclick() {
        mBinding.tvSendPay.setOnClickListener(v -> {
            PayActivity.open(OrderSubmitActivity.this);
        });
        mBinding.linLayoutAddress.setOnClickListener(v -> AddressListActivity.open(this, true));
    }

    @Subscribe
    public void addressSelect(AddressModel addressModel) {
        mBinding.tvReceiveName.setText(addressModel.getAddressee());
        mBinding.tvReceiveNumber.setText(addressModel.getMobile());
        mBinding.tvReceiveAddress.setText("收货地址:" +addressModel.getProvince() + " " + addressModel.getCity() + " " + addressModel.getArea() + "" + addressModel.getDetail());
    }


}
