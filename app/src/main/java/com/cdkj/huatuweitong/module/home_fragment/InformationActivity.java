package com.cdkj.huatuweitong.module.home_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.InformationAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.InformationBean;
import com.cdkj.huatuweitong.common.WebViewActivity2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 微车资讯
 */
public class InformationActivity extends AbsRefreshListActivity {


    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, InformationActivity.class);
            //品牌号
//            intent.putExtra(CdRouteHelper.DATASIGN, seriesCode);
            context.startActivity(intent);
        }

    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("微车资讯");
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        InformationAdapter informationAdapter = new InformationAdapter(listData);
        informationAdapter.setOnItemClickListener((adapter, view, position) -> {
            InformationBean.ListBean item = (InformationBean.ListBean) adapter.getItem(position);
            WebViewActivity2.openContent(this, item.getTitle(), item.getContext());
        });
        return informationAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        getData(pageindex, limit, isShowDialog);
    }

    private void getData(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog)
            showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("status", "1");//0待上架，1已上架，2已下架
//        map.put("tag", "1");
//        map.put("title", "1");
        Call<BaseResponseModel<InformationBean>> information = RetrofitUtils.createApi(MyApiServer.class).getInformation("630455", StringUtils.getJsonToString(map));
        information.enqueue(new BaseResponseModelCallBack<InformationBean>(this) {
            @Override
            protected void onSuccess(InformationBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无资讯", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });


        List<InformationBean> listData = new ArrayList<>();
        listData.add(new InformationBean());
        listData.add(new InformationBean());
        listData.add(new InformationBean());
        listData.add(new InformationBean());

    }
}
