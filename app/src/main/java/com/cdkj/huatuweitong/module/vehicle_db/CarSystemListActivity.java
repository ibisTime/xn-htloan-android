package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.CarSystemListAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarSystemBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdkj.huatuweitong.bean.CarSystemPageBean;
import retrofit2.Call;

public class CarSystemListActivity extends AbsRefreshListActivity {


    private HashMap<String, Serializable> selectMap;
    private String brandCode;
    private String queryName;

    public static void open(Context context, String brandCode) {
        Intent intent = new Intent(context, CarSystemListActivity.class);
        intent.putExtra("brandCode", brandCode);
        context.startActivity(intent);
    }

    public static void open(String queryName, Context context) {
        Intent intent = new Intent(context, CarSystemListActivity.class);
        intent.putExtra("queryName", queryName);
        context.startActivity(intent);
    }

    public static void open(Context context, HashMap selectMap) {
        Intent intent = new Intent(context, CarSystemListActivity.class);
        intent.putExtra("data", selectMap);
        context.startActivity(intent);
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        if (getIntent() != null) {
            selectMap = (HashMap<String, Serializable>) getIntent().getSerializableExtra("data");
            brandCode = getIntent().getStringExtra("brandCode");
            queryName = getIntent().getStringExtra("queryName");
        }
        mBaseBinding.titleView.setMidTitle("车系列表");
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMLoadMore(true);

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        CarSystemListAdapter carSystemListAdapter = new CarSystemListAdapter(listData);
        carSystemListAdapter.setOnItemClickListener((adapter, view, position) -> {
            CarSystemBean item = (CarSystemBean) adapter.getItem(position);

//            CarListActivity.open(this, item.getCode());
            CarListActivity.open(this, item);

        });
        return carSystemListAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initData(pageindex, limit, isShowDialog);
    }

    private void initData(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }
        String code = "630491";
        Map<String, Serializable> map = new HashMap<>();
        if (!TextUtils.isEmpty(brandCode)) {
            map.put("brandCode", brandCode); // 品牌编号
        } else if (selectMap != null) {
            map.putAll(selectMap);
        } else {
            map.put("name", queryName);
        }
        map.put("start", pageindex + "");
        map.put("limit", limit + "");
        map.put("status", "1");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarSystemPage(code, StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<CarSystemPageBean>(CarSystemListActivity.this) {
            @Override
            protected void onSuccess(CarSystemPageBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "车系数据为空", 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(CarSystemListActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
