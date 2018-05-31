package com.cdkj.huatuweitong.module.recharge;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityRechargeBinding;

/**
 * 充值界面
 */
public class RechargeActivity extends AbsBaseLoadActivity {
    private ActivityRechargeBinding mBinding;

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_recharge, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

    }
}
