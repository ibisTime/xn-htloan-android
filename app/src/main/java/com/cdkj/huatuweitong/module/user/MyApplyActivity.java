package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.cdkj.baselibrary.base.AbsTablayoutActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.module.order.AllOrderTabActivity;
import com.cdkj.huatuweitong.module.order.OrderListFragment;
import com.cdkj.huatuweitong.other.OrderHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : qianLei
 * @since : 2019/11/5 21:11
 */
public class MyApplyActivity extends AbsTablayoutActivity {

    public static void open(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, MyApplyActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void afterCreate(Bundle savedInstanceState) {
        super.afterCreate(savedInstanceState);
        mBaseBinding.titleView.setMidTitle("我的申请");
    }

    @Override
    public List<Fragment> getFragments() {

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(MyCarLoanFragment.getInstance("1"));
        fragments.add(MyCarLoanFragment.getInstance("2"));

        return fragments;
    }

    @Override
    public List<String> getFragmentTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("分期申请");
        titles.add("保险申请");
        return titles;
    }
}
