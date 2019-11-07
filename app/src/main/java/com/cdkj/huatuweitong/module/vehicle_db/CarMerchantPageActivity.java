package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.CarMerchantAdapter;
import com.cdkj.huatuweitong.adapters.HomeMerchantAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MerchantPageBean;
import retrofit2.Call;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : qianLei
 * @since : 2019/11/5 09:40
 */
public class CarMerchantPageActivity extends AbsRefreshListActivity<MerchantPageBean.ListBean> {

    public static void open(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CarMerchantPageActivity.class);
        context.startActivity(intent);
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<MerchantPageBean.ListBean> listData) {
        CarMerchantAdapter merchantAdapter = new CarMerchantAdapter(listData);

        merchantAdapter.setOnItemClickListener((adapter, view, position) -> {
            MerchantPageBean.ListBean item = (MerchantPageBean.ListBean) adapter
                    .getItem(position);
            CarMerchantDetailActivity.open(this, item.getCode());
        });

        return merchantAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        Map<String, String> map = new HashMap<>();
        map.put("isHighQuality", "1");
        map.put("start", pageindex + "");
        map.put("limit", limit + "");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMerchantPage("632065", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<MerchantPageBean>(this) {

            @Override
            protected void onSuccess(MerchantPageBean data, String SucMessage) {

                mRefreshHelper.setData(data.getList(), "暂无数据", 0);

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        mBaseBinding.titleView.setMidTitle("优质商家");

        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

    }
}
