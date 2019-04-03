package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.BrandActivityAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.BrandBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class BrandActivity extends AbsRefreshListActivity {

    public static void open(Context context) {
        Intent intent = new Intent(context, BrandActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
        mBaseBinding.titleView.setMidTitle("选择品牌");
        mRefreshBinding.rv.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        BrandActivityAdapter brandActivityAdapter = new BrandActivityAdapter(listData);
        brandActivityAdapter.setOnItemClickListener((adapter, view, position) -> {
            BrandBean brandBean = (BrandBean) adapter.getItem(position);
            CarSystemListActivity.open(this, brandBean.getCode());
        });
        return brandActivityAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initData(pageindex, limit, isShowDialog);
    }

    private void initData(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog)
            showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        Call<BaseResponseListModel<BrandBean>> brandData = RetrofitUtils.createApi(MyApiServer.class).getBrandData("630406", StringUtils.getJsonToString(map));
        brandData.enqueue(new BaseResponseListCallBack<BrandBean>(this) {
            @Override
            protected void onSuccess(List<BrandBean> data, String SucMessage) {
                mRefreshHelper.setData(data, "暂无品牌数据", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
