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
import com.cdkj.huatuweitong.adapters.CarSystemAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarBrandActivityBean;
import com.cdkj.huatuweitong.bean.CarModelActivityBean;
import com.cdkj.huatuweitong.bean.CarSystemActivityBean;
import com.chad.library.adapter.base.BaseQuickAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 车系选择
 */
public class CarSystemActivity extends AbsRefreshListActivity<CarSystemActivityBean> {
    private CarBrandActivityBean currentBean;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_car_system);
//    }

    public static void open(Context context, CarBrandActivityBean carBrandActivityBean) {
        if (context != null) {
            Intent intent = new Intent(context, CarSystemActivity.class);
            intent.putExtra("bean", carBrandActivityBean);
            context.startActivity(intent);
        }

    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("车系");
        if (getIntent() != null) {
            currentBean = (CarBrandActivityBean) getIntent().getSerializableExtra("bean");
        }
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<CarSystemActivityBean> listData) {

        CarSystemAdapter adapter = new CarSystemAdapter(listData);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapters, View view, int position) {
                EventBus.getDefault().post(listData.get(position));
                CarModeldActivity.open(CarSystemActivity.this, adapter.getItem(position));
            }
        });
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initDatas(pageindex, limit, isShowDialog);
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
        map.put("brandCode", currentBean.getCode());//品牌编号
        map.put("brandName", currentBean.getName());//品牌名称
        Call call = RetrofitUtils.createApi(MyApiServer.class).getCarSystemlDatas("630415", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<CarSystemActivityBean>>(CarSystemActivity.this) {
            @Override
            protected void onSuccess(ResponseInListModel data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "车系数据为空", 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
//                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(CarSystemActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


    /**
     * 接受车型数据
     *
     * @param bean
     */
    @Subscribe
    public void breakCarModelActivityBean(CarModelActivityBean bean) {
     //接受到车型数据 说明已经选择过了  所以 这个页面也要关闭
        finish();
    }
}
