package com.cdkj.huatuweitong.module.user;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.MyCarLoanFragmentAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MyCarLoanFragmentBean;
import com.cdkj.huatuweitong.module.mfirst_page.CarLoanCalculatorActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCarLoanFragment extends AbsRefreshListFragment<MyCarLoanFragmentBean> {
    private MyCarLoanFragmentAdapter adapter;
    String status;//状态  0未处理  1已处理

    public static MyCarLoanFragment getInstance(String status) {
        MyCarLoanFragment fragment = new MyCarLoanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("status", status);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void lazyLoad() {
    }


    @Override
    protected void onInvisible() {

    }

    @Override
    protected void afterCreate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bunndle = getArguments();
        status = bunndle.getString("status");

        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        if (adapter==null)
        adapter = new MyCarLoanFragmentAdapter(listData);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter madapter, View view, int position) {
                CarLoanCalculatorActivity.open(mActivity, adapter.getItem(position).getCode());
            }
        });
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initDatas(limit, pageindex, isShowDialog);
    }



    private void initDatas(int limit, int start, boolean isShowDialo) {
        Map<String, String> map = new HashMap<>();
        map.put("limit", limit + "");
        map.put("start", start + "");
        map.put("status", status);
        map.put("userId", SPUtilHelpr.getUserId());

        Call call = RetrofitUtils.createApi(MyApiServer.class).getMyCarLoanFrgmentData("630435", StringUtils.getJsonToString(map));
//        addCall(call);
        if (isShowDialo) {
            showLoadingDialog();
        }
        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<MyCarLoanFragmentBean>>(mActivity) {
            @Override
            protected void onSuccess(ResponseInListModel<MyCarLoanFragmentBean> data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), getString(R.string.empty_apply_order), 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                mRefreshHelper.loadError(errorCode, 0);
//                UITipDialog.showFall(mActivity, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }


}
