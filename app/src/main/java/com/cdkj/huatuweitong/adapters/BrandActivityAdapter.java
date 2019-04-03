package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.BrandBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/14
 */
public class BrandActivityAdapter extends BaseQuickAdapter<BrandBean, BaseViewHolder> {
    public BrandActivityAdapter(@Nullable List<BrandBean> data) {
        super(R.layout.item_brand_activity, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BrandBean item) {
        helper.setText(R.id.tv_brand_name, item.getName());
        ImgUtils.loadQiniuImg(mContext, item.getLogo(), helper.getView(R.id.iv_brand_img));
    }
}
