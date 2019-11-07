package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.MerchantPageBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author : qianLei
 * @since : 2019/11/5 14:55
 */
public class CarMerchantAdapter extends
        BaseQuickAdapter<MerchantPageBean.ListBean, BaseViewHolder> {

    public CarMerchantAdapter(@Nullable List<MerchantPageBean.ListBean> data) {
        super(R.layout.item_car_merchant, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MerchantPageBean.ListBean item) {

        ImgUtils.loadQiniuImg(mContext, item.getShopLogo(), helper.getView(R.id.iv_logo));

        helper.setText(R.id.tv_name, item.getFullName());
        helper.setText(R.id.tv_nums, "车源："+item.getCarCount() + "");
        helper.setText(R.id.tv_active, item.getTrends() + "");

    }
}
