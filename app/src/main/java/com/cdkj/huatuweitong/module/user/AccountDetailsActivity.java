package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.adapters.AccountDetailsAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.AccountDetailsBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 资金流水明细
 */
public class AccountDetailsActivity extends AbsRefreshListActivity<AccountDetailsBean.ListBean> {
    String accountNumber;

    public static void open(Context context, String accountNumber) {
        if (context != null) {
            Intent intent = new Intent(context, AccountDetailsActivity.class);
            intent.putExtra(CdRouteHelper.DATASIGN, accountNumber);
            context.startActivity(intent);
        }

    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("明细");
        if (getIntent() != null) {
            accountNumber = getIntent().getStringExtra(CdRouteHelper.DATASIGN);
        }
        initRefreshHelper(10);//先调用这句 初始化头部信息  否则会包空指针
        mRefreshHelper.onDefaluteMRefresh(true);//再第一次请求完成后  设置头部信息

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<AccountDetailsBean.ListBean> listData) {
        AccountDetailsAdapter mAadapter = new AccountDetailsAdapter(listData);

        return mAadapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initdatas(pageindex, limit, isShowDialog);
    }

    private void initdatas(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog) {
            showLoadingDialog();
        }

        Map<String, String> map = new HashMap<>();

        map.put("limit", limit + "");
        map.put("start", pageindex + "");
        map.put("accountNumber", accountNumber);

        Call<BaseResponseModel<AccountDetailsBean>> accountMoneyList = RetrofitUtils.createApi(MyApiServer.class).getAccountMoneyList("802520", StringUtils.getJsonToString(map));

        accountMoneyList.enqueue(new BaseResponseModelCallBack<AccountDetailsBean>(AccountDetailsActivity.this) {
            @Override
            protected void onSuccess(AccountDetailsBean data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无流水数据", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }
}
