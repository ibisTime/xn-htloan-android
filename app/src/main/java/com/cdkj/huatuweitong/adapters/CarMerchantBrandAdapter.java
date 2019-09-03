package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarSelectPageBean;
import com.cdkj.huatuweitong.bean.MerchantBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class CarMerchantBrandAdapter extends BaseQuickAdapter<MerchantBean.BrandListBean, BaseViewHolder> {
    public CarMerchantBrandAdapter(@Nullable List<MerchantBean.BrandListBean> data) {
        super(R.layout.item_merchant_brand, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MerchantBean.BrandListBean item) {
        ImgUtils.loadQiniuImg(mContext, item.getBrandLogo(), helper.getView(R.id.iv_brand_img));
        helper.setText(R.id.tv_brand_name, item.getBrandName());

    }
}
