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
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.CarSystemListAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarSystemListBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class CarSystemListActivity extends AbsRefreshListActivity {


    private HashMap<String, Serializable> selectMap;
    private String brandCode;
    private String queryName;
    private boolean isMore;

    public static void open(Context context, String brandCode) {
        Intent intent = new Intent(context, CarSystemListActivity.class);
        intent.putExtra("brandCode", brandCode);
        context.startActivity(intent);
    }

    public static void open(Context context, boolean isMore) {
        Intent intent = new Intent(context, CarSystemListActivity.class);
        intent.putExtra("isMore", isMore);
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
            isMore = getIntent().getBooleanExtra("isMore", false);
        }
        mBaseBinding.titleView.setMidTitle("车系列表");
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMLoadMore(true);

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        CarSystemListAdapter carSystemListAdapter = new CarSystemListAdapter(listData);
        carSystemListAdapter.setOnItemClickListener((adapter, view, position) -> {
            CarSystemListBean item = (CarSystemListBean) adapter.getItem(position);

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
        String code = "630426";
        Map<String, Serializable> map = new HashMap<>();
        if (!TextUtils.isEmpty(brandCode)) {
            map.put("brandCode", brandCode);//品牌编号
            code = "630416";
        } else if (selectMap != null) {
            map.putAll(selectMap);
        } else if (isMore) {
            map.put("isMore", "1");
        } else {
            map.put("queryName", queryName);
        }
        map.put("start", pageindex + "");
        map.put("limit", limit + "");
//        map.put("location", "0");
        map.put("status", "1");

        Call<BaseResponseListModel<CarSystemListBean>> carSystemlListDatas = RetrofitUtils.createApi(MyApiServer.class).getCarSystemlListDatas(code, StringUtils.getJsonToString(map));
        addCall(carSystemlListDatas);
        carSystemlListDatas.enqueue(new BaseResponseListCallBack<CarSystemListBean>(CarSystemListActivity.this) {
            @Override
            protected void onSuccess(List<CarSystemListBean> data, String SucMessage) {
                mRefreshHelper.setData(data, "车系数据为空", 0);
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
