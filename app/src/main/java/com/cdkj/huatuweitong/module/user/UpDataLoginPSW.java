package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityUpDataLoginPswBinding;


public class UpDataLoginPSW extends AbsBaseLoadActivity {
    ActivityUpDataLoginPswBinding mBinding;
    private int type;//如果  type=1说明是点击修改密码进来的   如果等于2说明是点击修改支付密码过来的

    public static void open(Context context,int type) {
        if (context != null) {
            Intent intent = new Intent(context, UpDataLoginPSW.class);
            intent.putExtra("TYPE",type);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_up_data_login_psw, null, false);
        Intent intent = getIntent();
        if (intent != null) {
            type = intent.getIntExtra("TYPE", 0);
        }
        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        if (type == 1) {
            mBaseBinding.titleView.setMidTitle(getString(R.string.UpDateLogInPSW));
        } else if (type == 2) {
            mBaseBinding.titleView.setMidTitle(getString(R.string.UpDatePayPSW));
        }

        initOnclick();
    }

    private void initOnclick() {

    }
}
