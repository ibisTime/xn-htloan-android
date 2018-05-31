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

/**
 * 账户积分
 */
public class AccountIntegraActivity extends AbsRefreshListActivity<AccountDetailsBean.ListBean> {

    private TextView tvCurrentIntegral;
    private String accountNumber;//再通过这个获取流水
    private View headView;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, AccountIntegraActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("账户积分");
        initRefreshHelper(10);

        initDatas();
    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<AccountDetailsBean.ListBean> listData) {
        MyCurrentActivityApter adapter = new MyCurrentActivityApter(listData);
        headView = View.inflate(AccountIntegraActivity.this, R.layout.head_my_current, null);
        tvCurrentIntegral = headView.findViewById(R.id.tv_current_integral);
        TextView tvTitle = headView.findViewById(R.id.tv_title);
        tvTitle.setText("当前账户积分");
        adapter.addHeaderView(headView);
        adapter.setHeaderAndEmpty(true);
        return adapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initDatas(pageindex, limit, isShowDialog);
    }


    private void initDatas(int pageindex, int limit, boolean isShowDialog) {
        initDataList(pageindex, limit, isShowDialog);

    }

    /**
     * 获取数据
     */
    private void initDatas() {
//        802503
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("userId", SPUtilHelpr.getUserId());
        map.put("currency", "JF");

        Call<BaseResponseModel<MyAccountBean>> accountMoneyJF = RetrofitUtils.createApi(MyApiServer.class).getAccountMoney("802503", StringUtils.getJsonToString(map));
        accountMoneyJF.enqueue(new BaseResponseModelCallBack<MyAccountBean>(AccountIntegraActivity.this) {

            @Override
            protected void onSuccess(MyAccountBean data, String SucMessage) {
                if (data == null || data.getAccountList() == null) {
                    UITipDialog.showFall(AccountIntegraActivity.this, "获取数据失败");
                    return;
                }
                MyAccountBean.AccountListBean accountListBean = data.getAccountList().get(0);
//                amount
                tvCurrentIntegral.setText(accountListBean.getAmount().intValue() + "");

                //再获取到accountNumber  再通过这个获取流水
                accountNumber = accountListBean.getAccountNumber();

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
        accountMoneyList.enqueue(new BaseResponseModelCallBack<AccountDetailsBean>(AccountIntegraActivity.this) {
            @Override
            protected void onSuccess(AccountDetailsBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无积分流水", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }
}
