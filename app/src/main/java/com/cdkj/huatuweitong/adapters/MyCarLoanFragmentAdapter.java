package com.cdkj.huatuweitong.adapters;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.MyCarLoanFragmentBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/17
 * Created by lenovo on 2018/5/17.
 */

public class MyCarLoanFragmentAdapter extends BaseQuickAdapter<MyCarLoanFragmentBean, BaseViewHolder> {
    public MyCarLoanFragmentAdapter(@Nullable List<MyCarLoanFragmentBean> data) {
        super(R.layout.item_my_car_loan_fragment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCarLoanFragmentBean item) {
        helper.setText(R.id.tv_order_number, item.getCode());
        if ("1".equals(item.getStatus())) {
            helper.setText(R.id.tv_type, "已通过");
            helper.setTextColor(R.id.tv_type, Color.rgb(153, 153, 153));

        } else if (TextUtils.equals("2", item.getStatus())) {
            helper.setText(R.id.tv_type, "未通过");
            helper.setTextColor(R.id.tv_type, Color.rgb(47, 147, 237));
        }
//        else if (TextUtils.equals("2", item.getStatus())) {
//            helper.setText(R.id.tv_type, "已作废");
//            helper.setTextColor(R.id.tv_type, Color.rgb(153, 153, 153));
//        }

//        MyTextUtils.setStatusType004(helper.getView(R.id.tv_type),item.getStatus());

        helper.setText(R.id.tv_name, item.getSeriesName());

        helper.setText(R.id.tv_total_money, "总价: " + MoneyUtils.getShowPriceSign(item.getPrice()));
        helper.setText(R.id.tv_one_pay, "首付: " + MoneyUtils.getShowPriceSign(item.getSfAmount()));
        ImageView ivLogo = helper.getView(R.id.iv_logo);
        ImgUtils.loadQiniuImg(mContext,item.getCar().getPic(),ivLogo);
//        iv_logo
    }
}
