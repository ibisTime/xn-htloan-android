package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityMyCarLoanBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MyCarLoanActivity extends AbsBaseLoadActivity {
    ActivityMyCarLoanBinding mBinding;

    public static void open(Context context) {
        if (context!=null) {
            context.startActivity(new Intent(context,MyCarLoanActivity.class));
        }

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_my_car_loan, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle(getString(R.string.my_car_loan));
        initViewPager();
        initViewPagerIndicator();
    }

    /**
     * 初始化适配器
     */
    private void initViewPagerIndicator() {
        mBinding.viewindicator.setmLinWidth(25);
        mBinding.viewindicator.setVisibleTabCount(3);
        mBinding.viewindicator.setTabItemTitles(Arrays.asList("全部", "已通过", "未通过"));
        mBinding.viewindicator.setViewPager(mBinding.viewpager, 0);
    }


    /**
     * 初始化ViewPager
     */
    private void initViewPager() {

        //设置fragment数据
        ArrayList fragments = new ArrayList<>();

        fragments.add(MyCarLoanFragment.getInstance(""));
        fragments.add(MyCarLoanFragment.getInstance("1"));
        fragments.add(MyCarLoanFragment.getInstance("2"));

        mBinding.viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        mBinding.viewpager.setOffscreenPageLimit(fragments.size());
        mBinding.viewpager.setPagingEnabled(true);
    }
}
