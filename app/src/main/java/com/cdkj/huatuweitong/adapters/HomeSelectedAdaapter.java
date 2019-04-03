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
 * @updateDts 2019/3/13
 */
public class HomeSelectedAdaapter extends BaseQuickAdapter<CarSystemListBean, BaseViewHolder> {
    public HomeSelectedAdaapter(@Nullable List<CarSystemListBean> data) {
        super(R.layout.item_selected, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarSystemListBean item) {
        ImgUtils.loadQiniuImg(mContext, item.getAdvPic(), helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_title, item.getName());
        helper.setText(R.id.tv_price, MoneyUtils.formatNum(item.getPrice()));
        helper.setText(R.id.tv_follow,"99人关注");//人关注

    }
}
