package com.cdkj.huatuweitong.module.order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.OrderListAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.OrderBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 订单列表
 * Created by cdkj on 2018/5/18.
 */

public class OrderListFragment extends AbsRefreshListFragment {

    public static OrderListFragment getInstance() {
        OrderListFragment fragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void afterCreate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        OrderListAdapter orderListAdapter = new OrderListAdapter(listData, this);
        orderListAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (orderListAdapter.getItem(0) == null) return;
            OrderDetailsActivity.open(mActivity, orderListAdapter.getItem(position).getCode());
        });
        return orderListAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {

        Map<String, String> map = new HashMap<>();

        map.put("applyUser", SPUtilHelpr.getUserId());
        map.put("limit", limit + "");
        map.put("start", pageindex + "");

        Call<BaseResponseModel<ResponseInListModel<OrderBean>>> call = RetrofitUtils.createApi(MyApiServer.class).getOrderList("808068", StringUtils.getJsonToString(map));

        if (isShowDialog) {
            showLoadingDialog();
        }

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<OrderBean>>(mActivity) {
            @Override
            protected void onSuccess(ResponseInListModel<OrderBean> data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无订单", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }
}
