package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarSelectPageBean;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class HomeSelectedAdapter extends BaseQuickAdapter<CarSelectPageBean.ListBean, BaseViewHolder> {
    public HomeSelectedAdapter(@Nullable List<CarSelectPageBean.ListBean> data) {
        super(R.layout.item_selected, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarSelectPageBean.ListBean item) {
        ImgUtils.loadQiniuImg(mContext, item.getPic(), helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_title, item.getName());
        helper.setText(R.id.tv_price, MoneyUtils.formatNum(item.getSalePrice()));
        helper.setText(R.id.tv_follow, item.getCollectNumber() + "人关注");//人关注

    }
}
