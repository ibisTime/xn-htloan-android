package com.cdkj.huatuweitong.adapters;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarLoanDetailsActivityBean;
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
        helper.setText(R.id.tv_time, item.getRepayDatetime());
        helper.setText(R.id.tv_money, MoneyUtils.showPriceDouble(item.getPayedAmount() + item.getOverplusAmount()));
        int progress = (int) (item.getPayedAmount() / (item.getPayedAmount() + item.getOverplusAmount()) * 100);//已还比例
        pb.setProgress(progress);

        if (item.getStatus().equals("0")) {
            if (0 != (int) item.getOverplusAmount() && item.getPayedAmount() == 0) {
                //剩余金额  不等于0  已还金额等于0  说明还是为还状态
                helper.setText(R.id.tv_type, "未还");
                helper.setTextColor(R.id.tv_type, Color.rgb(153, 153, 153));
            } else {
                helper.setText(R.id.tv_type, "已还" + MoneyUtils.showPriceDouble(item.getPayedAmount()) + "   " + "剩余" + MoneyUtils.showPriceDouble(item.getOverplusAmount()));
                helper.setTextColor(R.id.tv_type, Color.rgb(47, 147, 237));
            }

        } else if (item.getStatus().equals("1")) {
            //还款已完成
            helper.setText(R.id.tv_type, "已还");
            helper.setTextColor(R.id.tv_type, Color.rgb(153, 153, 153));
        } else if (item.getStatus().equals("5")) {
            //逾期
            helper.setText(R.id.tv_type, "逾期");
            helper.setTextColor(R.id.tv_type, Color.RED);
        }

//                helper.tv_time
//        helper.tv_number
//        helper.tv_money
//        helper.tv_type
    }
}
