package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.CarModelAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarModelActivityBean;
import com.cdkj.huatuweitong.bean.CarSystemActivityBean;
import com.chad.library.adapter.base.BaseQuickAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class CarModeldActivity extends AbsRefreshListActivity<CarModelActivityBean> {

    private CarSystemActivityBean currentBean;

    public static void open(Context context, CarSystemActivityBean carBrandActivityBean) {
        if (context != null) {
            Intent intent = new Intent(context, CarModeldActivity.class);
            intent.putExtra("bean", carBrandActivityBean);
            context.startActivity(intent);
        }

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<CarModelActivityBean> listData) {
        CarModelAdapter adapter = new CarModelAdapter(listData);
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
        mBaseBinding.titleView.setMidTitle("车型");


        if (getIntent() != null) {
            currentBean = (CarSystemActivityBean) getIntent().getSerializableExtra("bean");
        }
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
        map.put("brandCode", currentBean.getBrandCode());//品牌编号
        map.put("seriesCode", currentBean.getCode());//品牌编号
        map.put("seriesName", currentBean.getName());//品牌编号

        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarModelDatas("630426", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseListCallBack(CarModeldActivity.this) {
            @Override
            protected void onSuccess(List data, String SucMessage) {
                mRefreshHelper.setData(data, "车型数据为空", 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
//                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarModeldActivity.this, errorMessage);
                Log.e("pppppp", "onSuccess: "+errorMessage );
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }
}
