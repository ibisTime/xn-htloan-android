package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.CarBrandAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarBrandActivityBean;
import com.chad.library.adapter.base.BaseQuickAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class CarBrandActivity extends AbsRefreshListActivity<CarBrandActivityBean> {

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, CarBrandActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<CarBrandActivityBean> listData) {
        CarBrandAdapter adapter = new CarBrandAdapter(listData);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                EventBus.getDefault().post(listData.get(position));
                finish();
            }
        });
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initDatas(pageindex, limit, isShowDialog);
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("品牌");
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

    }


    public void initDatas(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }

        Map<String, String> map = new HashMap<>();
        map.put("start", pageindex + "");
        map.put("limit", limit + "");
        map.put("location", "0");
        map.put("status", "1");
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarBrandDatas("630405", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<CarBrandActivityBean>>(CarBrandActivity.this) {
            @Override
            protected void onSuccess(ResponseInListModel data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "品牌数据为空", 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
//                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarBrandActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }
}
