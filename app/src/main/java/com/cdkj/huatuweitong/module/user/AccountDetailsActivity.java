package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cdkj.baselibrary.api.BaseResponseModel;
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

public class AccountDetailsActivity extends AbsRefreshListActivity<AccountDetailsBean> {

    public static void open(Context context) {
        if (context!=null) {
            context.startActivity(new Intent(context,AccountDetailsActivity.class));
        }

    }
    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("详情");
        initRefreshHelper(10);
        mRefreshHelper.onDefaluteMRefresh(true);

    }

    @Override
    public RecyclerView.Adapter getListAdapter(List<AccountDetailsBean> listData) {

//        ArrayList<AccountDetailsBean> datas = new ArrayList<>();
//        datas.add(null);
//        datas.add(null);
//        datas.add(null);
//        datas.add(null);
        AccountDetailsAdapter mAadapter = new AccountDetailsAdapter(listData);

        return mAadapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        initdatas(pageindex,limit,isShowDialog);
    }

    private void initdatas(int pageindex, int limit, boolean isShowDialog) {
        if (isShowDialog){
//            showLoadingDialog();
        }

        Map<String, String> map = new HashMap<>();

        map.put("currency", "CNY");
        map.put("limit", limit+"");
        map.put("start", pageindex+"");
        map.put("status","1");//1 已回调待对账

        Call<BaseResponseModel<AccountDetailsBean>> accountMoneyList = RetrofitUtils.createApi(MyApiServer.class).getAccountMoneyList("802520", StringUtils.getJsonToString(map));

        accountMoneyList.enqueue(new BaseResponseModelCallBack<AccountDetailsBean>(AccountDetailsActivity.this) {
            @Override
            protected void onSuccess(AccountDetailsBean data, String SucMessage) {

            }

            @Override
            protected void onFinish() {

            }
        });

    }
}
