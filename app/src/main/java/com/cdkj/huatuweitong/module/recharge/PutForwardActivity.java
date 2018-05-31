package com.cdkj.huatuweitong.module.recharge;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityPutForwardBinding;

public class PutForwardActivity extends AbsBaseLoadActivity {
    private ActivityPutForwardBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, PutForwardActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_put_forward, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("提现");
    }
}
