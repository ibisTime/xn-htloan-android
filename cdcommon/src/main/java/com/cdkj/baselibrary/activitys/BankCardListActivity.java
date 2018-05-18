package com.cdkj.baselibrary.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cdkj.baselibrary.activitys.bankcard.AddBankCardActivity;
import com.cdkj.baselibrary.adapters.BankCardListAdapter;
import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsRefreshListActivity;
import com.cdkj.baselibrary.model.BankCardModel;
import com.cdkj.baselibrary.model.MyBankCardListMode;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * Created by cdkj on 2018/5/18.
 */

public class BankCardListActivity extends AbsRefreshListActivity {
    private boolean isSelect;

    /**
     * 是否进行银行卡选择
     *
     * @param context
     * @param isSelect
     */
    public static void open(Context context, boolean isSelect) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, BankCardListActivity.class);
        intent.putExtra("isSelect", isSelect);
        context.startActivity(intent);
    }


    @Override
    public RecyclerView.Adapter getListAdapter(List listData) {
        BankCardListAdapter bankCardListAdapter = new BankCardListAdapter(listData);
        bankCardListAdapter.setOnItemClickListener((adapter, view, position) -> {
            BankCardModel bankCardModel = bankCardListAdapter.getItem(position);
            if (bankCardModel == null) return;
            if (isSelect) {//如果是选择银行卡
                EventBus.getDefault().post(bankCardModel);
                finish();
            } else {
                UpdateBankCardActivity.open(BankCardListActivity.this, bankCardModel);
            }
        });
        return bankCardListAdapter;
    }

    @Override
    public void getListRequest(int pageindex, int limit, boolean isShowDialog) {
        Map<String, String> object = new HashMap<>();

        object.put("systemCode", MyCdConfig.SYSTEMCODE);
        object.put("token", SPUtilHelpr.getUserToken());
        object.put("userId", SPUtilHelpr.getUserId());
        object.put("start", pageindex + "");
        object.put("limit", limit + "");

        Call<BaseResponseModel<MyBankCardListMode>> call = RetrofitUtils.getBaseAPiService().getCardListData("802015", StringUtils.getJsonToString(object));

        addCall(call);
        if (isShowDialog) {
            showLoadingDialog();
        }
        call.enqueue(new BaseResponseModelCallBack<MyBankCardListMode>(this) {
            @Override
            protected void onSuccess(MyBankCardListMode data, String SucMessage) {
                mRefreshHelper.setData(data.getList(), "暂无银行卡", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    @Override
    public void topTitleViewRightClick() {
        AddBankCardActivity.open(this);
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setRightTitle("添加");
        mBaseBinding.titleView.setMidTitle("我的银行卡");
        initRefreshHelper(10);

        if (getIntent() != null) {
            isSelect = getIntent().getBooleanExtra("isSelect", false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mRefreshHelper!=null){
            mRefreshHelper.onDefaluteMRefresh(true);
        }
    }
}
