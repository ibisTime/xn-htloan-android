package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityPayBinding;

public class PayActivity extends AbsBaseLoadActivity {
    ActivityPayBinding mBinding;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, PayActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_pay, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.OrderSubmit));

        initOnclick();
    }

    private void initOnclick() {
        mBinding.llYue.setOnClickListener(v -> {
            mBinding.ivYue.setImageResource(R.mipmap.ic_pay_check);
            mBinding.ivWechat.setImageResource(R.mipmap.ic_pay_uncheck);
            mBinding.ivAli.setImageResource(R.mipmap.ic_pay_uncheck);
        });

        mBinding.llWechat.setOnClickListener(v -> {
            mBinding.ivYue.setImageResource(R.mipmap.ic_pay_uncheck);
            mBinding.ivWechat.setImageResource(R.mipmap.ic_pay_check);
            mBinding.ivAli.setImageResource(R.mipmap.ic_pay_uncheck);
        });

        mBinding.llAli.setOnClickListener(v -> {
            mBinding.ivYue.setImageResource(R.mipmap.ic_pay_uncheck);
            mBinding.ivWechat.setImageResource(R.mipmap.ic_pay_uncheck);
            mBinding.ivAli.setImageResource(R.mipmap.ic_pay_check);
        });
    }

    private void setCheck(View v){
        switch (v.getId()){
//            case mBinding.ivAli:
        }

    }
}
