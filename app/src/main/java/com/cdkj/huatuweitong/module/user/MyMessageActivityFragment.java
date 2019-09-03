package com.cdkj.huatuweitong.module.user;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.MyMessageAFAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MsgListModel;
import com.cdkj.huatuweitong.common.WebViewActivity2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import com.cdkj.huatuweitong.module.vehicle_db.CarDetailsActivity;
import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyMessageActivityFragment extends AbsRefreshListFragment<MsgListModel> {


    private String type;

    private int limit = 1;
    private int pageIndex = 10;

    public static Fragment getInstance(String type) {

        MyMessageActivityFragment fragment = new MyMessageActivityFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    protected void afterCreate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getString("type");
        }
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mRefreshHelper != null) {
            mRefreshHelper.onMRefresh(pageIndex, limit, true);
        }
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {

        MyMessageAFAdapter adapter = new MyMessageAFAdapter(listData);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            MsgListModel.ListBean item = (MsgListModel.ListBean) adapter1.getItem(position);

            switch (item.getType()) {
                case "1":
                case "3":
                    WebViewActivity2.open(mActivity, item.getRefCode());
                    break;

                case "2":
                    WebViewArticleActivity.open(mActivity, item.getRefCode());
                    break;

                case "4":
                    CarDetailsActivity.open(mActivity, item.getRefCode());
                    break;
            }

        });

        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {

        pageIndex = pageindex;
        this.limit = limit;

        Map<String, String> map = new HashMap<>();
        map.put("start", pageindex + "");
        map.put("limit", limit + "");
        map.put("token", SPUtilHelper.getUserToken());

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMsgList("805305", StringUtils.getJsonToString(map));

        addCall(call);

        if (isShowDialog) {
            showLoadingDialog();
        }

        call.enqueue(new BaseResponseModelCallBack<MsgListModel>(mActivity) {
            @Override
            protected void onSuccess(MsgListModel data, String SucMessage) {
                String emptyStr = "暂无消息";
                switch (type) {
                    case "1":
                        //提醒
                        emptyStr = "暂无提醒消息";
                        break;
                    case "2":
                        emptyStr = "暂无通知消息";
                        break;
                    case "3":
                        emptyStr = "暂无公告消息";
                        break;
                }

                mRefreshHelper.setData(data.getList(), emptyStr, 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                mRefreshHelper.loadError(errorMessage, 0);
            }


            @Override
            protected void onNoNet(String msg) {
                mRefreshHelper.loadError(msg, 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }

}
