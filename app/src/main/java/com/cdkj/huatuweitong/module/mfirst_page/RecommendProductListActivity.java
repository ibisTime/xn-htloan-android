package com.cdkj.huatuweitong.module.mfirst_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.RecommendProductAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.RecommendProductBean;
import com.cdkj.huatuweitong.module.product.ProductDetailsActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * Created by cdkj on 2018/6/1.
 */

public class RecommendProductListActivity extends AbsRefreshListActivity {

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, RecommendProductListActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        RecommendProductAdapter recommendProductAdapter = new RecommendProductAdapter(listData, this);

        recommendProductAdapter.setOnItemClickListener((adapter, view, position) -> {

            RecommendProductBean recommendProductBean = recommendProductAdapter.getItem(position);
            if (recommendProductBean == null) return;
            ProductDetailsActivity.open(RecommendProductListActivity.this, recommendProductBean.getCode());
        });

        return recommendProductAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        Map<String, String> map = new HashMap<>();
        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("location", "1");
        map.put("status", "3");

        Call<BaseResponseModel<ResponseInListModel<RecommendProductBean>>> call = RetrofitUtils.createApi(MyApiServer.class).getRecommentdProductList("808025", StringUtils.getJsonToString(map));

        addCall(call);

        if (isShowDialog) {
            showLoadingDialog();
        }

        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<RecommendProductBean>>(this) {
            @Override
            protected void onSuccess(ResponseInListModel<RecommendProductBean> data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), getString(R.string.no_recommend_product), 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("推荐分期");

        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

    }
}
