package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityBean;
import com.cdkj.huatuweitong.utlis.MyTextUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/17
 * Created by lenovo on 2018/5/17.
 */

public class RepaymentPlanActivityAdapter extends BaseQuickAdapter<CarLoanDetailsActivityBean.RepayPlanListBean, BaseViewHolder> {
    List<CarLoanDetailsActivityBean.RepayPlanListBean> data;

    public RepaymentPlanActivityAdapter(@Nullable List<CarLoanDetailsActivityBean.RepayPlanListBean> data) {
        super(R.layout.item_repayment_plan_activity, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, CarLoanDetailsActivityBean.RepayPlanListBean item) {
        ProgressBar pb = helper.getView(R.id.pb);
        helper.setText(R.id.tv_number, (int) item.getCurPeriods() + "/" + (int) item.getPeriods() + "期");
        helper.setText(R.id.tv_time, DateUtil.formatStringData(item.getRepayDatetime(), DateUtil.DATE_YMD));
        helper.setText(R.id.tv_money, MoneyUtils.showPriceDouble(item.getRepayCapital()));
        MyTextUtils.setStatusTypeAll(helper.getView(R.id.tv_type), item.getCurNodeCode());

        //计算已还比例
        int progress = (int) (item.getPayedAmount() / item.getRepayCapital() * 100);//已还比例
        pb.setProgress(progress);

    }
}
