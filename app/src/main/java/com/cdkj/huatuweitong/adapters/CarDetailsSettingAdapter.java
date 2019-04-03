package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarDetailsSettingBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/14
 */
public class CarDetailsSettingAdapter extends BaseQuickAdapter<CarDetailsSettingBean, BaseViewHolder> {
    public CarDetailsSettingAdapter(@Nullable List<CarDetailsSettingBean> data) {
        super(R.layout.item_brand_activity, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarDetailsSettingBean item) {
        CarDetailsSettingBean.ConfigBean config = item.getConfig();
        helper.setText(R.id.tv_brand_name, config.getName());
        ImgUtils.loadQiniuImg(mContext, config.getPic(), helper.getView(R.id.iv_brand_img));
    }
}
