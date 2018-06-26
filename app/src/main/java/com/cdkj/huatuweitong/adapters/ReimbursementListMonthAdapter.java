package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.ReimbursementRepaymentMonthBean;
import com.cdkj.huatuweitong.utlis.MyTextUtils;
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
        if (TextUtils.equals(item.getRepayBiz().getRefType(), "0")) {
            helper.setText(R.id.tv_type_loan, "车辆贷");
        } else if (TextUtils.equals(item.getRepayBiz().getRefType(), "1")) {
            helper.setText(R.id.tv_type_loan, "商品贷");
        }

        helper.setText(R.id.tv_price, MoneyUtils.showPriceDouble(item.getOverplusAmount()));
        helper.setText(R.id.tv_time, DateUtil.formatStringData(item.getRepayDatetime(), DateUtil.DATE_YMD));//loanEndDatetime

        MyTextUtils.setStatusType004(helper.getView(R.id.tv_type),item.getStatus());

    }
}
