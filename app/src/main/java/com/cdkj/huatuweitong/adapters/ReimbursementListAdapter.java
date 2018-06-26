package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.ReimbursementRepaymentBean;
import com.cdkj.huatuweitong.utlis.MyTextUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * 还款列表 adapter
 * Created by cdkj on 2018/4/9.
 */

public class ReimbursementListAdapter extends BaseQuickAdapter<ReimbursementRepaymentBean, BaseViewHolder> {

    private Object obj;

    public ReimbursementListAdapter(@Nullable List<ReimbursementRepaymentBean> data, Object obj) {
        super(R.layout.item_reimbursement, data);
        SoftReference<Object> mS = new SoftReference<>(obj);
        this.obj = mS.get();
    }

    @Override
    protected void convert(BaseViewHolder helper, ReimbursementRepaymentBean item) {
        if (item == null) {

            return;
        }
        if (TextUtils.equals(item.getRefType(), "0")) {
            helper.setText(R.id.tv_type_loan, "车辆贷");
        } else if (TextUtils.equals(item.getRefType(), "1")) {
            helper.setText(R.id.tv_type_loan, "商品贷");
        }


        helper.setText(R.id.tv_price, MoneyUtils.showPriceDouble(item.getLoanAmount()));
        helper.setText(R.id.tv_time, DateUtil.formatStringData(item.getLoanEndDatetime(), DateUtil.DATE_YMD));//loanEndDatetime

        MyTextUtils.setStatusType004(helper.getView(R.id.tv_type), item.getStatus());
    }
}
