package com.cdkj.huatuweitong.module.reimbursement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.ReimbursementListAdapter;
import com.cdkj.huatuweitong.adapters.ReimbursementListMonthAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.ReimbursementRepaymentBean;
import com.cdkj.huatuweitong.bean.ReimbursementRepaymentMonthBean;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 还款列表
 * Created by cdkj on 2018/5/1.
 */

public class ReimbursementListFragment extends AbsRefreshListFragment {
    String type;//1代表近期还款  2代表借款记录

    public static ReimbursementListFragment getInstance(String type) {
        ReimbursementListFragment fragment = new ReimbursementListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
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
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getString("type");
        }
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);
    }


    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        if (TextUtils.equals(type, "2")) {
            ReimbursementListAdapter adapter = getReimbursementListAdapter(listData);
            return adapter;
        } else if (TextUtils.equals(type, "1")) {
            return getReimbursementListMonthAdapter(listData);
        }
        return null;
    }

    /**
     * 本月应还贷款的  adapter
     *
     * @param listData
     * @return
     */
    private ReimbursementListMonthAdapter getReimbursementListMonthAdapter(List listData) {
        //本月应还
        ReimbursementListMonthAdapter adapter = new ReimbursementListMonthAdapter(listData);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter aadapter, View view, int position) {
                CarLoanDetailsActivity.open(getContext(), adapter.getItem(position).getCode(), type);
            }
        });
        return adapter;
    }

    /**
     * 总贷款
     *
     * @param listData
     * @return
     */
    private ReimbursementListAdapter getReimbursementListAdapter(List listData) {

        ReimbursementListAdapter adapter = new ReimbursementListAdapter(listData, this);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter aadapter, View view, int position) {
                CarLoanDetailsActivity.open(getContext(), adapter.getItem(position).getCode(), type);
            }
        });
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        if (!SPUtilHelpr.isLoginNoStart()) {
            return;
        }

        if ("1".equals(type)) {
            //本月的应还款
            initMonthData(pageindex, limit, isShowDialog);
        } else if ("2".equals(type)) {
            //是所有的贷款
            initRepaymentData(pageindex, limit, isShowDialog);
        }
    }

    /**
     * 获取本月应还的数据
     */
    public void initMonthData(int pageindex, int limit, boolean isShowDialog) {


        Map<String, String> map = new HashMap<>();
        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("userId", SPUtilHelpr.getUserId());

        if (isShowDialog) {
            showLoadingDialog();
        }


        Call<BaseResponseModel<ResponseInListModel<ReimbursementRepaymentMonthBean>>> call = RetrofitUtils.createApi(MyApiServer.class).getReimbursementRepaymentMonthData("630543", StringUtils.getJsonToString(map));

        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<ReimbursementRepaymentMonthBean>>(mActivity) {
            @Override
            protected void onSuccess(ResponseInListModel data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "近期暂无还款", 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(mActivity, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });
    }

    /**
     * 获取全部贷款的数据
     *
     * @param pageindex
     * @param limit
     * @param isShowDialog
     */
    private void initRepaymentData(int pageindex, int limit, boolean isShowDialog) {

        Map<String, String> map = new HashMap<>();

        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("userId", SPUtilHelpr.getUserId());
        if (isShowDialog) {
            showLoadingDialog();
        }
        Call call = RetrofitUtils.createApi(MyApiServer.class).getReimbursementRepaymentData("630520", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<ReimbursementRepaymentBean>>(mActivity) {

            @Override
            protected void onSuccess(ResponseInListModel<ReimbursementRepaymentBean> data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无借款记录", 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(mActivity, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });
    }
}