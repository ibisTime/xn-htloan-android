package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class CarSystemListAdapter extends BaseQuickAdapter<CarSystemListBean, BaseViewHolder> {

    public CarSystemListAdapter(@Nullable List<CarSystemListBean> data) {
        super(R.layout.item_car_system_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarSystemListBean item) {
        ImgUtils.loadQiniuImg(mContext, item.getAdvPic(), helper.getView(R.id.img_product));
        helper.setText(R.id.tv_product_title, item.getName());
        helper.setText(R.id.tv_type, item.getSlogan());
        helper.setText(R.id.tv_price, MoneyUtils.formatNum(item.getLowest()) + "元-" + MoneyUtils.formatNum(item.getHighest()) + "元");
    }
}
