package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.InformationAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.DataDictionaryBean;
import com.cdkj.huatuweitong.bean.InformationListBean;
import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : qianLei
 * @since : 2019/11/5 19:08
 */
public class InfoPageActivity extends AbsRefreshListActivity<InformationListBean.ListBean> {

    private List<DataDictionaryBean> list = new ArrayList<>();

    public static void open(Context context) {
        Intent intent = new Intent(context, InfoPageActivity.class);
        context.startActivity(intent);

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<InformationListBean.ListBean> listData) {
        InformationAdapter informationAdapter = new InformationAdapter(listData, list);
        informationAdapter.setOnItemClickListener((adapter, view, position) -> {
            InformationListBean.ListBean item = (InformationListBean.ListBean) adapter
                    .getItem(position);
            WebViewArticleActivity.open(this, item.getCode());
        });
        return informationAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }
        Map<String, String> map = new HashMap<>();
        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("status", "1");//0待上架，1已上架，2已下架
        Call<BaseResponseModel<InformationListBean>> information = RetrofitUtils
                .createApi(MyApiServer.class)
                .getInformationList("630455", StringUtils.getJsonToString(map));
        information.enqueue(new BaseResponseModelCallBack<InformationListBean>(this) {
            @Override
            protected void onSuccess(InformationListBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无资讯", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        mBaseBinding.titleView.setMidTitle("玩车资讯");
        getCarNumber();
    }

    /**
     * 获取规格的值
     */
    private void getCarNumber() {
        Map<String, String> map = new HashMap<>();
        map.put("parentKey", "car_news_tag");

        showLoadingDialog();
        Call<BaseResponseListModel<DataDictionaryBean>> dataDictionary = RetrofitUtils
                .createApi(MyApiServer.class)
                .getDataDictionary("630036", StringUtils.getJsonToString(map));
        addCall(dataDictionary);
        dataDictionary.enqueue(new BaseResponseListCallBack<DataDictionaryBean>(this) {
            @Override
            protected void onSuccess(List<DataDictionaryBean> data, String SucMessage) {

                if (data != null) {
                    list.addAll(data);
                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();

                initRefreshHelper(10);
                mRefreshHelper.onDefaluteMRefresh(true);
            }
        });

    }
}
