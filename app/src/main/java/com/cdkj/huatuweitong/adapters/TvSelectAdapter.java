package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.TvSelectBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/14
 */
public class TvSelectAdapter extends BaseQuickAdapter<TvSelectBean, BaseViewHolder> {
    public TvSelectAdapter(@Nullable List<TvSelectBean> data) {
        super(R.layout.item_textview_select, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TvSelectBean item) {
        helper.setText(R.id.tv_current, item.getName());
        if (item.isSelect()) {
            helper.setTextColor(R.id.tv_current, mContext.getResources().getColor(R.color.title_bg));
            helper.setBackgroundRes(R.id.tv_current, R.drawable.bg_gary_select);
        } else {
            helper.setTextColor(R.id.tv_current, mContext.getResources().getColor(R.color.text_black_cd));
            helper.setBackgroundRes(R.id.tv_current, R.drawable.bg_gary);
        }
    }
}
