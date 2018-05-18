package com.cdkj.huatuweitong.module.reimbursement;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.RepaymentPlanActivityAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityBean;
import com.cdkj.huatuweitong.databinding.ActivityRepaymentPlanBinding;

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
//        restAmount

        if (getIntent() != null) {
            currentData = (CarLoanDetailsActivityBean) getIntent().getSerializableExtra("data");
        }

        mBinding.tvBeizhu.setText("(包含利息"+ MoneyUtils.showPriceDouble(currentData.getRestAmount())+"元)");
        mBinding.tvBeLeftOver.setText(MoneyUtils.showPriceDouble(currentData.getRestAmount()));

        Map<String, String> map = new HashMap<>();
        Call call = RetrofitUtils.createApi(MyApiServer.class).getReimbursementRepaymentData("", StringUtils.getJsonToString(map));
        addCall(call);

        mBinding.recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<CarLoanDetailsActivityBean.RepayPlanListBean> repayPlanList = currentData.getRepayPlanList();
        mBinding.recycler.setAdapter(new RepaymentPlanActivityAdapter(repayPlanList));
    }
}
