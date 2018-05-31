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
 * @author qi
 * @updateDts 2018/5/22
 */

public class AccountDetailsAdapter extends BaseQuickAdapter<AccountDetailsBean.ListBean, BaseViewHolder> {
    public AccountDetailsAdapter(@Nullable List<AccountDetailsBean.ListBean> data) {
//        super(R.layout.item_account_details, data);//这个是效果图
        super(R.layout.item_current_activity, data);;//因为数据不全暂时先展示这个
    }

    @Override
    protected void convert(BaseViewHolder helper, AccountDetailsBean.ListBean item) {

//        ImageView iv_logo = helper.getView(R.id.iv_logo);
//        helper.setText(R.id.tv_day,"");//日
//        helper.setText(R.id.tv_time,"");//时间
//        helper.setText(R.id.tv_add,"");//增加多少  减少多少
//        helper.setText(R.id.tv_message,"");//消费信息

        helper.setText(R.id.tv_loan_type, item.getBizNote());
        helper.setText(R.id.tv_time, DateUtil.formatStringData(item.getCreateDatetime(), DateUtil.DATE_YMD));
        helper.setText(R.id.iv_add, item.getTransAmountString());

        TextView tv_type = helper.getView(R.id.tv_type);
        TextView tv_money = helper.getView(R.id.tv_money);
        tv_type.setVisibility(View.GONE);
        tv_money.setVisibility(View.GONE);

    }
}
