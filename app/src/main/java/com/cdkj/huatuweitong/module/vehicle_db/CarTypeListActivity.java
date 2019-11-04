package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.CarSystemListAdapter;
import com.cdkj.huatuweitong.adapters.CarTypeListAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.*;
import retrofit2.Call;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarTypeListActivity extends AbsRefreshListActivity {

    private HashMap<String, Serializable> selectMap;

    private String brandCode;
    private String carDealerCode;

    public static void open(Context context, HashMap selectMap) {
        Intent intent = new Intent(context, CarTypeListActivity.class);
        intent.putExtra("data", selectMap);
        context.startActivity(intent);
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        if (getIntent() != null) {
            selectMap = (HashMap<String, Serializable>) getIntent().getSerializableExtra("data");
        }
        initRefreshHelper(10);
        mBaseBinding.titleView.setMidTitle("");
        mRefreshHelper.onDefaluteMLoadMore(true);

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        CarTypeListAdapter mAdapter = new CarTypeListAdapter(listData);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            CarBean item = (CarBean) mAdapter.getItem(position);
            CarDetailsActivity.open(CarTypeListActivity.this, item.getCode());
        });
        return mAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initData(pageindex, limit, isShowDialog);
    }

    private void initData(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }
        Map<String, Serializable> map = new HashMap<>();
        if (selectMap != null) {
            map.putAll(selectMap);
        }
        map.put("start", pageindex + "");
        map.put("limit", limit + "");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarTypePage("630492", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<CarSelectPageBean>(CarTypeListActivity.this) {
            @Override
            protected void onSuccess(CarSelectPageBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "车型数据为空", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
