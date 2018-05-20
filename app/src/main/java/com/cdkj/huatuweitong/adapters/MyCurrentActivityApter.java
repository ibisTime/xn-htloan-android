package com.cdkj.huatuweitong.adapters;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.MyCurrentActivityBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/19
 * Created by lenovo on 2018/5/19.
 */

public class MyCurrentActivityApter extends BaseQuickAdapter<MyCurrentActivityBean, BaseViewHolder> {

    public MyCurrentActivityApter(@Nullable List<MyCurrentActivityBean> data) {
        super(R.layout.item_current_activity, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCurrentActivityBean item) {
        helper.setText(R.id.tv_loan_type, "车辆带");
        helper.setText(R.id.tv_money, "¥ 2999.9");
        helper.setText(R.id.tv_time, "2018-10-01 23:59:00");
        helper.setText(R.id.iv_add, "+1");


        helper.setText(R.id.tv_type, "已逾期");
        helper.setTextColor(R.id.tv_type, Color.RED);

    }
}
