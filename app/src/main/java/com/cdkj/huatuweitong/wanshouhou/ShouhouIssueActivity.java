package com.cdkj.huatuweitong.wanshouhou;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import cn.jzvd.JzvdStd;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MainResourceBean;
import com.cdkj.huatuweitong.module.mfirst_page.RecommendProductListActivity;
import com.cdkj.huatuweitong.wanshouhou.adapter.ShouhouIssueAdapter;
import com.cdkj.huatuweitong.wanshouhou.bean.ShouhouIssueBean;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : qianLei
 * @since : 2019/11/4 16:57
 */
public class ShouhouIssueActivity extends AbsRefreshListActivity {

    private String type;

    public static void open(Context context, String type) {
        Intent intent = new Intent(context, ShouhouIssueActivity.class);
        intent.putExtra(CdRouteHelper.DATASIGN, type);
        context.startActivity(intent);
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        return new ShouhouIssueAdapter(listData);
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        Map<String, String> map = RetrofitUtils.getRequestMap();

        map.put("type", type);
        map.put("status", "2");
        map.put("start", pageindex + "");
        map.put("limit", limit + "");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getShouhouIssuePage("630595", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<ShouhouIssueBean>(this) {

            @Override
            protected void onSuccess(ShouhouIssueBean data, String SucMessage) {

                mRefreshHelper.setData(data.getList(), "暂无问题", 0);

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        mBaseBinding.titleView.setMidTitle("问题分类");

        type = getIntent().getStringExtra(CdRouteHelper.DATASIGN);

        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
    }
}
