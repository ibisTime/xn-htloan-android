package com.cdkj.huatuweitong.adapters;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.ReimbursementRepaymentBean;
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
        if (TextUtils.equals(item.getRefType(),"0")) {
            helper.setText(R.id.tv_price,"车辆贷");
        }else if (TextUtils.equals(item.getRefType(),"0")){
            helper.setText(R.id.tv_price,"商品贷");
        }

        helper.setText(R.id.tv_price, MoneyUtils.showPriceDouble(item.getLoanAmount()));
        helper.setText(R.id.tv_time,item.getLoanEndDatetime());//loanEndDatetime
        ;
        if ("1".equals(item.getStatus())){
            //已还完
        helper.setText(R.id.tv_type,"已完成");
            helper.setTextColor(R.id.tv_type, Color.rgb(153,153,153));
        }else if("0".equals(item.getStatus())){

        helper.setText(R.id.tv_type,"还款中");
        helper.setTextColor(R.id.tv_type,Color.rgb(47,147,237));
        }


    }
}
