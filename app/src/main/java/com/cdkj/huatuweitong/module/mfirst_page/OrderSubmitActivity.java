package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityOrderSubmitBinding;

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
    }
}
