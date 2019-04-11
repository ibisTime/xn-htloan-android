package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.TvSelectBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class LevelAdapter extends BaseQuickAdapter<TvSelectBean, BaseViewHolder> {
    public LevelAdapter(@Nullable List<TvSelectBean> data) {
        super(R.layout.item_brand_ver_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TvSelectBean item) {
        helper.setText(R.id.tv_brand_name, item.getName());
        helper.setImageResource(R.id.iv_brand_img, item.getPic());

        if (item.isSelect()) {
            helper.setTextColor(R.id.tv_brand_name, mContext.getResources().getColor(R.color.title_bg));
            helper.setBackgroundRes(R.id.ll_root, R.drawable.bg_gary_select);
        } else {
            helper.setTextColor(R.id.tv_brand_name, mContext.getResources().getColor(R.color.text_black_cd));
            helper.setBackgroundColor(R.id.ll_root, mContext.getResources().getColor(R.color.white));
        }

    }
}
