package com.cdkj.huatuweitong.module.reimbursement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.huatuweitong.adapters.ReimbursementListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * 还款列表
 * Created by cdkj on 2018/5/1.
 */

public class ReimbursementListFragment extends AbsRefreshListFragment {

    public static ReimbursementListFragment getInstance() {
        ReimbursementListFragment fragment = new ReimbursementListFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    protected void afterCreate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRefreshHelper(10);
//        mRefreshBinding.rv.
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {

        listData.add("");
        listData.add("");
        listData.add("");
        listData.add("");
        listData.add("");
        ReimbursementListAdapter adapter = new ReimbursementListAdapter(listData, this);


        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CarLoanDetailsActivity.open(getContext());
            }
        });
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {

    }
}