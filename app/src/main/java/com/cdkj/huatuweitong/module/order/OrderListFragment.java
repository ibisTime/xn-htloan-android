package com.cdkj.huatuweitong.module.order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.api.ResponseInListModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsRefreshListFragment;
import com.cdkj.baselibrary.dialog.CommonDialog;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.OrderListAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.OrderBean;
import com.cdkj.huatuweitong.bean.PaySucc;
import com.cdkj.huatuweitong.module.mfirst_page.PayActivity;
import com.cdkj.huatuweitong.other.OrderHelper;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 订单列表
 * Created by cdkj on 2018/5/18.
 */

public class OrderListFragment extends AbsRefreshListFragment {

    private String orderState = "";//订单状态

    /**
     * @param orderState 要查询的订单状态
     * @return
     */
    public static OrderListFragment getInstance(String orderState) {
        OrderListFragment fragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CdRouteHelper.DATASIGN, orderState);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void afterCreate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRefreshHelper(10);

        if (getArguments() != null) {
            orderState = getArguments().getString(CdRouteHelper.DATASIGN);
        }

        mRefreshHelper.onDefaluteMRefresh(true);
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        OrderListAdapter orderListAdapter = new OrderListAdapter(listData, this);
        orderListAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (orderListAdapter.getItem(0) == null) return;
            OrderDetailsActivity.open(mActivity, orderListAdapter.getItem(position).getCode());
        });

        orderListAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            OrderBean orderBean = orderListAdapter.getItem(position);

            if (orderBean == null) return;

            switch (view.getId()) {
                case R.id.tv_cancel_order:
                    showDoubleWarnListen("确认取消订单？", view1 -> {
                        cancelOrder(orderBean.getCode(), position);
                    });
                    break;

                case R.id.tv_order_state:

                    if (TextUtils.equals(orderBean.getStatus(), OrderHelper.ORDER_STATE.TO_PAY.getState())) {
                        PayActivity.open(mActivity, orderBean.getCode(), MoneyUtils.showPrice(orderBean.getAmount()), true);
                        return;
                    }
                    if (TextUtils.equals(orderBean.getStatus(), OrderHelper.ORDER_STATE.SEND.getState())) {
                        showDoubleWarnListen("确认收货？", view1 -> {
                            sureGetOrder(orderBean.getCode(), position);
                        });
                        return;
                    }

                    break;
            }
        });
        return orderListAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {

        Map<String, Object> map = new HashMap<>();

        map.put("applyUser", SPUtilHelpr.getUserId());
        map.put("limit", limit + "");
        map.put("start", pageindex + "");

        if (!TextUtils.isEmpty(orderState)){
            List<String> status = new ArrayList<>(1);
            status.add(orderState);
            map.put("statusList", status);
        }

        Call<BaseResponseModel<ResponseInListModel<OrderBean>>> call = RetrofitUtils.createApi(MyApiServer.class).getOrderList("808068", StringUtils.getJsonToString(map));

        if (isShowDialog) {
            showLoadingDialog();
        }

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<ResponseInListModel<OrderBean>>(mActivity) {
            @Override
            protected void onSuccess(ResponseInListModel<OrderBean> data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无订单", 0);
            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
               // super.onReqFailure(errorCode, errorMessage);

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


    /**
     * 接收支付成功通知 刷新订单列表
     *
     * @param paySucc
     */
    @Subscribe
    public void paysuccEventRefresh(PaySucc paySucc) {

        if (mRefreshHelper != null && getUserVisibleHint()) {
            mRefreshHelper.onDefaluteMRefresh(false);
        }

    }

    /**
     * 取消订单
     *
     * @param orderCode
     * @param position
     */
    public void cancelOrder(String orderCode, int position) {

        if (TextUtils.isEmpty(orderCode)) return;

        Map<String, String> map = new HashMap<>();

        map.put("code", orderCode);
        map.put("userId", SPUtilHelpr.getUserId());

        showLoadingDialog();

        Call<BaseResponseModel<IsSuccessModes>> call = RetrofitUtils.getBaseAPiService().successRequest("808053", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(mActivity) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                if (data.isSuccess()) {
                    UITipDialog.showSuccess(mActivity, "订单取消成功", dialog -> {
                        if (mRefreshHelper != null) {
                            mRefreshHelper.onDefaluteMRefresh(true);
                        }
                    });
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    /**
     * 确认收货
     *
     * @param orderCode
     * @param position
     */
    public void sureGetOrder(String orderCode, int position) {

        if (TextUtils.isEmpty(orderCode)) return;

        Map<String, String> map = new HashMap<>();

        map.put("code", orderCode);
        map.put("userId", SPUtilHelpr.getUserId());

        showLoadingDialog();

        Call<BaseResponseModel<IsSuccessModes>> call = RetrofitUtils.getBaseAPiService().successRequest("808057", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(mActivity) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {
                if (data.isSuccess()) {
                    UITipDialog.showSuccess(mActivity, "收货成功", dialog -> {
                        if (mRefreshHelper != null) {
                            mRefreshHelper.onDefaluteMRefresh(true);
                        }
                    });
                }
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    protected void showDoubleWarnListen(String str, CommonDialog.OnPositiveListener onPositiveListener) {

        if (mActivity == null && mActivity.isFinishing()) {
            return;
        }

        CommonDialog commonDialog = new CommonDialog(mActivity).builder()
                .setTitle("提示").setContentMsg(str)
                .setPositiveBtn("确定", onPositiveListener)
                .setNegativeBtn("取消", null, false);

        commonDialog.show();
    }

    @Override
    protected void lazyLoad() {
        if (mRefreshBinding == null)
            return;

        mRefreshHelper.onDefaluteMRefresh(true);
    }

    @Override
    protected void onInvisible() {

    }
}
