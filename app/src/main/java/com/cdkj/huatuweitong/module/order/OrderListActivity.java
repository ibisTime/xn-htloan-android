package com.cdkj.huatuweitong.module.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
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

public class OrderListActivity extends AbsRefreshListActivity {


    public static void open(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, OrderListActivity.class);
        context.startActivity(intent);
    }


    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        return new OrderListAdapter(listData, this);
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

        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<OrderBean>>(this) {
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
    public void afterCreate(Bundle savedInstanceState) {
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
        mBaseBinding.titleView.setMidTitle("我的订单");
    }


}
