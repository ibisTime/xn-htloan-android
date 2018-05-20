package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.MyCurrentActivityApter;
import com.cdkj.huatuweitong.bean.MyCurrentActivityBean;

import java.util.ArrayList;
import java.util.List;

public class MyCurrentActivity extends AbsRefreshListActivity<MyCurrentActivityBean> {

    private TextView tvCurrentIntegral;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, MyCurrentActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<MyCurrentActivityBean> listData) {
        MyCurrentActivityApter adapter = new MyCurrentActivityApter(listData);
        View view = View.inflate(MyCurrentActivity.this, R.layout.head_my_current, null);
        tvCurrentIntegral = view.findViewById(R.id.tv_current_integral);
        adapter.addHeaderView(view);
        adapter.setHeaderAndEmpty(true);
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initDatas(pageindex, limit, isShowDialog);
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("信用报告");
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
    }

    private void initDatas(int pageindex, int limit, boolean isShowDialog) {
        List<MyCurrentActivityBean> ddd = new ArrayList<>();
        ddd.add(null);
        ddd.add(null);
        ddd.add(null);
        ddd.add(null);
        mRefreshHelper.setData(ddd, "暂无贷款数据", 0);
        tvCurrentIntegral.setText("0");
    }
}
