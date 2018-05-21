package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.RecommendProductBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * 推荐产品 adapter
 * Created by cdkj on 2018/4/9.
 */

public class RecommendProductAdapter extends BaseQuickAdapter<RecommendProductBean, BaseViewHolder> {

    private Object obj;

    public RecommendProductAdapter(@Nullable List<RecommendProductBean> data, Object obj) {
        super(R.layout.item_recommend_product, data);
        SoftReference<Object> mS = new SoftReference<>(obj);
        this.obj = mS.get();
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendProductBean item) {
        if (item == null) return;

        ImgUtils.loadQiniuImg(obj, StringUtils.getAsPicListIndexOne(item.getAdvPic()), helper.getView(R.id.img_product));

        helper.setGone(R.id.tv_state, !TextUtils.isEmpty(item.getSaleStatus()));
        helper.setText(R.id.tv_state, item.getSaleStatus());
        helper.setText(R.id.tv_product_title, item.getName());
        helper.setText(R.id.tv_product_price, MoneyUtils.formatNum(MoneyUtils.getPriceValue(item.getPrice())));

        if (item.getProductSpecsList() != null && item.getProductSpecsList().size() > 0) {
            helper.setText(R.id.tv_mouth_money, "月供:" + MoneyUtils.getShowPriceSign(item.getProductSpecsList().get(0).getMonthAmount()));
        }

    }


}
