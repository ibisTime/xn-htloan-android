package com.cdkj.huatuweitong.adapters;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.ReimbursementRepaymentMonthBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 还款列表 adapter
 * Created by cdkj on 2018/4/9.
 */

public class ReimbursementListMonthAdapter extends BaseQuickAdapter<ReimbursementRepaymentMonthBean, BaseViewHolder> {


    public ReimbursementListMonthAdapter(@Nullable List<ReimbursementRepaymentMonthBean> data) {
        super(R.layout.item_reimbursement, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReimbursementRepaymentMonthBean item) {
        if (item == null) {

            return;
        }
        //后台接口重新部署 后放开即可

//        if (TextUtils.equals(item.getRepayBiz().getRefType(), "0")) {
//            helper.setText(R.id.tv_type_loan, "车辆贷");
//        } else if (TextUtils.equals(item.getRepayBiz().getRefType(), "0")) {
//            helper.setText(R.id.tv_type_loan, "商品贷");
//        }

        helper.setText(R.id.tv_price, MoneyUtils.showPriceDouble(item.getMonthRepayAmount()));
        helper.setText(R.id.tv_time, item.getRepayDatetime());//loanEndDatetime

        if (TextUtils.equals("1", item.getStatus())) {
            //已还完
            helper.setText(R.id.tv_type, "已完成");
            helper.setTextColor(R.id.tv_type, Color.rgb(153, 153, 153));
        } else if ("0".equals(item.getStatus())) {

            helper.setText(R.id.tv_type, "还款中");
            helper.setTextColor(R.id.tv_type, Color.rgb(47, 147, 237));
        }

    }
}
