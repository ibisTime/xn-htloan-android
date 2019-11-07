package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.HomeSelectedAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarBean;
import com.cdkj.huatuweitong.bean.CarSelectPageBean;
import retrofit2.Call;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : qianLei
 * @since : 2019/11/5 22:07
 */
public class CarPageActivity extends AbsRefreshListActivity<CarBean> {

    public static void open(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CarPageActivity.class);
        context.startActivity(intent);
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<CarBean> listData) {
        HomeSelectedAdapter homeSelectedAdapter = new HomeSelectedAdapter(listData);
        homeSelectedAdapter.setOnItemClickListener((adapter, view, position) -> {

            CarBean item = (CarBean) adapter
                    .getItem(position);
            CarDetailsActivity.open(this, item.getCode());
        });

        return homeSelectedAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("location", "0");//1 热门 0普通
        map.put("start", pageindex + "");
        map.put("limit", limit + "");
        map.put("orderDir", "asc");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarTypePage("630492", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<CarSelectPageBean>(this) {

            @Override
            protected void onSuccess(CarSelectPageBean data, String SucMessage) {

                mRefreshHelper.setData(data.getList(), "暂无车型", 0);

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        mBaseBinding.titleView.setMidTitle("经典车型");
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

        mRefreshBinding.rv.setLayoutManager(
                new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    }
}
