package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarSelectPageBean;
import com.cdkj.huatuweitong.bean.MerchantPageBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class HomeMerchantAdapter extends BaseQuickAdapter<MerchantPageBean.ListBean, BaseViewHolder> {
    public HomeMerchantAdapter(@Nullable List<MerchantPageBean.ListBean> data) {
        super(R.layout.item_merchant_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MerchantPageBean.ListBean item) {
        helper.setText(R.id.tv_brand_name, item.getAbbrName());
        ImgUtils.loadQiniuImg(mContext, item.getShopLogo(), helper.getView(R.id.iv_brand_img));




    }
}
