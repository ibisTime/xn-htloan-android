package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.AccountDetailsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class AccountDetailsAdapter extends BaseQuickAdapter<AccountDetailsBean, BaseViewHolder> {
    public AccountDetailsAdapter(@Nullable List<AccountDetailsBean> data) {
        super(R.layout.item_account_details, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AccountDetailsBean item) {

        ImageView iv_logo = helper.getView(R.id.iv_logo);
        helper.setText(R.id.tv_day,"");//日
        helper.setText(R.id.tv_time,"");//时间
        helper.setText(R.id.tv_add,"");//增加多少  减少多少
        helper.setText(R.id.tv_message,"");//消费信息

    }
}
