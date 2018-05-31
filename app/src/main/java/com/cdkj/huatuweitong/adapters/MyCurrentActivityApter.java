package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.AccountDetailsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/19
 * Created by lenovo on 2018/5/19.
 */

public class MyCurrentActivityApter extends BaseQuickAdapter<AccountDetailsBean.ListBean, BaseViewHolder> {

    public MyCurrentActivityApter(@Nullable List<AccountDetailsBean.ListBean> data) {
        super(R.layout.item_current_activity, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AccountDetailsBean.ListBean item) {
//        helper.setText(R.id.tv_loan_type, "车辆带");
//        helper.setText(R.id.tv_money, "¥ 2999.9");
//        helper.setText(R.id.tv_time, "2018-10-01 23:59:00");
//        helper.setText(R.id.iv_add, "+1");
//        helper.setText(R.id.tv_type, "已逾期");
//        helper.setTextColor(R.id.tv_type, Color.RED);

        helper.setText(R.id.tv_loan_type, item.getBizNote());
        helper.setText(R.id.tv_time, DateUtil.formatStringData(item.getCreateDatetime(), DateUtil.DATE_YMD));
        helper.setText(R.id.iv_add, item.getTransAmountString());



        TextView tv_type = helper.getView(R.id.tv_type);
        TextView tv_money = helper.getView(R.id.tv_money);
        tv_type.setVisibility(View.GONE);
        tv_money.setVisibility(View.GONE);

    }
}
