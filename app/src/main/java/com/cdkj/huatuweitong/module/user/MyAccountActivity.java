package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.cdkj.baselibrary.api.BaseResponseModel;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.MyAccountBean;
import com.cdkj.huatuweitong.bean.MyAccountMoneyDataBean;
import com.cdkj.huatuweitong.databinding.ActivityMyAccountBinding;
import com.cdkj.huatuweitong.module.user.account.WithdrawActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * 我的账户
 */
public class MyAccountActivity extends AbsBaseLoadActivity {
    ActivityMyAccountBinding mBinding;
    String accountNumber;

    public static void open(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, MyAccountActivity.class));
        }

    }


    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("我的账户");
        mBaseBinding.titleView.setRightTitle("明细");
        mBaseBinding.titleView.setRightFraClickListener(v -> {
            //跳转详情界面
            if (TextUtils.isEmpty(accountNumber)) {
                UITipDialog.showInfo(MyAccountActivity.this, "暂无流水数据");
                return;
            }
            AccountDetailsActivity.open(this, accountNumber);
        });
        mBinding.btnRecharge.setVisibility(View.GONE);
        initDatas();
        initDatasMoney();
        initListener();
    }


    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_my_account, null, false);
        return mBinding.getRoot();
    }

    private void initListener() {
        mBinding.btnAdd.setOnClickListener(view -> {
            WithdrawActivity.open(this, accountNumber, mBinding.tvMoney.getText().toString().trim());
        });
    }

    /**
     * 获取数据
     */
    private void initDatas() {
//        802503
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("userId", SPUtilHelpr.getUserId());
        map.put("currency", "CNY");

        Call<BaseResponseModel<MyAccountBean>> accountMoney = RetrofitUtils.createApi(MyApiServer.class).getAccountMoney("802503", StringUtils.getJsonToString(map));
        accountMoney.enqueue(new BaseResponseModelCallBack<MyAccountBean>(MyAccountActivity.this) {
            @Override
            protected void onSuccess(MyAccountBean data, String SucMessage) {
                //如果参数传了币种  返回的集合里只可能是一条数据
                if (data == null || data.getAccountList() == null) {
                    UITipDialog.showFall(MyAccountActivity.this, "获取数据失败");
                    return;
                }
                MyAccountBean.AccountListBean accountListBean = data.getAccountList().get(0);
                accountNumber = accountListBean.getAccountNumber();
                mBinding.tvMoney.setText(MoneyUtils.showPrice(accountListBean.getAmount()));
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    /**
     * 获取统计信息  就是三个列表的值
     */
    private void initDatasMoney() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("userId", SPUtilHelpr.getUserId());
        Call<BaseResponseModel<MyAccountMoneyDataBean>> myAccountMoney = RetrofitUtils.createApi(MyApiServer.class).getMyAccountMoney("802900", StringUtils.getJsonToString(map));
        addCall(myAccountMoney);
        myAccountMoney.enqueue(new BaseResponseModelCallBack<MyAccountMoneyDataBean>(MyAccountActivity.this) {
            @Override
            protected void onSuccess(MyAccountMoneyDataBean data, String SucMessage) {
                mBinding.tvRechargeMoney.setText("¥" + MoneyUtils.showPrice(data.getTotalCharge()));//outAmount
                mBinding.tvSpendMoney.setText("¥" + MoneyUtils.showPrice(data.getTotalConsume()));//inAmount
                mBinding.tvAddMoney.setText("¥" + MoneyUtils.showPrice(data.getTotalWithdraw()));
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });
    }

}
