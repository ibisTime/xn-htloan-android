package com.cdkj.huatuweitong.module.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cdkj.baselibrary.base.AbsTablayoutActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.other.OrderHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdkj on 2018/5/19.
 */

public class AllOrderTabActivity extends AbsTablayoutActivity {

    public static void open(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, AllOrderTabActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void afterCreate(Bundle savedInstanceState) {
        super.afterCreate(savedInstanceState);
        mBaseBinding.titleView.setMidTitle(getString(R.string.my_order));
//        mTabLayoutBinding.tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public List<Fragment> getFragments() {

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(OrderListFragment.getInstance(""));
        fragments.add(OrderListFragment.getInstance(OrderHelper.ORDER_STATE.TO_PAY.getState()));
        fragments.add(OrderListFragment.getInstance(OrderHelper.ORDER_STATE.PAY_YES.getState()));
        fragments.add(OrderListFragment.getInstance(OrderHelper.ORDER_STATE.SEND.getState()));
        fragments.add(OrderListFragment.getInstance(OrderHelper.ORDER_STATE.RECEIVE.getState()));

        return fragments;
    }

    @Override
    public List<String> getFragmentTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("待支付");
        titles.add("待发货");
        titles.add("已发货");
        titles.add("已收货");
        return titles;
    }
}
