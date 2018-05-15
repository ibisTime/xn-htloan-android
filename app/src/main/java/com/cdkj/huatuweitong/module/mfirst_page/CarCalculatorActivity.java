package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.CarLoanCalculatorBinding;

/**
 * 车贷计算器
 */
public class CarCalculatorActivity extends AbsBaseLoadActivity {

    private CarLoanCalculatorBinding mBinding;

    public static void open(Context context){
//        startActivity();
        if (context!=null){
            Intent intent=new Intent(context,CarCalculatorActivity.class);
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
        mBaseBinding.titleView.setMidTitle("jisuanqi");
//        mBinding.tvMoney.setText("0.00");
    }
}
