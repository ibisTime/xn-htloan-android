package com.cdkj.huatuweitong.module.reimbursement;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.RepaymentPlanActivityAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityBean;
import com.cdkj.huatuweitong.bean.TextBean;
import com.cdkj.huatuweitong.databinding.ActivityRepaymentPlanBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class RepaymentPlanActivity extends AbsBaseLoadActivity {
    ActivityRepaymentPlanBinding mBinding;
    CarLoanDetailsActivityBean currentData;

    public static void open(Context context, CarLoanDetailsActivityBean data) {
        if (context != null) {
            Intent intent = new Intent(context, RepaymentPlanActivity.class);
            //品牌号
            intent.putExtra("data", data);
            context.startActivity(intent);
        }

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_repayment_plan, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("还款计划");

        if (getIntent() != null) {
            currentData = (CarLoanDetailsActivityBean) getIntent().getSerializableExtra("data");
        }

        mBinding.tvBeizhu.setText("(包含利息" + MoneyUtils.getShowPriceSign(currentData.getRestAmount()) + "元)");
        mBinding.tvBeLeftOver.setText(MoneyUtils.getShowPriceSign(currentData.getRestAmount()));

        mBinding.recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<CarLoanDetailsActivityBean.RepayPlanListBean> repayPlanList = currentData.getRepayPlanList();
        RepaymentPlanActivityAdapter adapter = new RepaymentPlanActivityAdapter(repayPlanList);
        mBinding.recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(BaseQuickAdapter aadapter, View view, int position) {

//                showDoubleWarnListen("提前还本期", new CommonDialog.OnPositiveListener() {
//                    @Override
//                    public void onPositive(View view) {
//                        CarLoanDetailsActivityBean.RepayPlanListBean item = adapter.getItem(position);
//                        requestNet(item.getCode());
//                    }
//
//
//                });
            }


        });
    }

    /**
     * 发起请求还本期
     */
    private void requestNet(String code) {

        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        Call call = RetrofitUtils.createApi(MyApiServer.class).requestEarlyRepaymentCurrent("630530", StringUtils.getJsonToString(map));
        addCall(call);
        call.enqueue(new BaseResponseModelCallBack<TextBean>(RepaymentPlanActivity.this) {
            @Override
            protected void onSuccess(TextBean data, String SucMessage) {

            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                super.onReqFailure(errorCode, errorMessage);
                UITipDialog.showFall(RepaymentPlanActivity.this, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();

            }
        });


    }

}

