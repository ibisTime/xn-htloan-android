package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.MyCurrentActivityApter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.AccountDetailsBean;
import com.cdkj.huatuweitong.bean.MyAccountBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class MyCurrentActivity extends AbsRefreshListActivity<AccountDetailsBean.ListBean> {

    private TextView tvCurrentIntegral;
    private String accountNumber;
    private View headView;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, MyCurrentActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<AccountDetailsBean.ListBean> listData) {
        MyCurrentActivityApter adapter = new MyCurrentActivityApter(listData);
        adapter.addHeaderView(headView);
        adapter.setHeaderAndEmpty(true);
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initDataList(pageindex, limit, isShowDialog);
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("信用报告");
        headView = View.inflate(MyCurrentActivity.this, R.layout.head_my_current, null);
        tvCurrentIntegral = headView.findViewById(R.id.tv_current_integral);

        initDatas();
    }


    /**
     * 获取数据
     */
    private void initDatas() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("userId", SPUtilHelpr.getUserId());
        map.put("currency", "XYF");
        Call<BaseResponseModel<MyAccountBean>> accountMoney = RetrofitUtils.createApi(MyApiServer.class).getAccountMoney("802503", StringUtils.getJsonToString(map));
        accountMoney.enqueue(new BaseResponseModelCallBack<MyAccountBean>(MyCurrentActivity.this) {
            @Override
            protected void onSuccess(MyAccountBean data, String SucMessage) {
                //如果参数传了币种  返回的集合里只可能是一条数据
                if (data == null || data.getAccountList() == null) {
                    UITipDialog.showFall(MyCurrentActivity.this, "获取数据失败");
                    return;
                }
                MyAccountBean.AccountListBean accountListBean = data.getAccountList().get(0);
                tvCurrentIntegral.setText((int) accountListBean.getAmount()+"");
                accountNumber = accountListBean.getAccountNumber();
                initRefreshHelper(10);
                mRefreshHelper.onDefaluteMRefresh(true);
            }
            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }


    public void initDataList(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }
        Map<String, String> map = new HashMap<>();
        map.put("start", pageindex + "");
        map.put("limit", limit + "");
        map.put("accountNumber", accountNumber);

        Call<BaseResponseModel<AccountDetailsBean>> accountMoneyList = RetrofitUtils.createApi(MyApiServer.class).getAccountMoneyList("802520", StringUtils.getJsonToString(map));
        accountMoneyList.enqueue(new BaseResponseModelCallBack<AccountDetailsBean>(MyCurrentActivity.this) {
            @Override
            protected void onSuccess(AccountDetailsBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "信用报告暂无", 0);
            }
            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

}
