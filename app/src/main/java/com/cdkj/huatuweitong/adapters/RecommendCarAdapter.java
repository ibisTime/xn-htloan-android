package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.FirstPageCarRecommendBean;
import com.cdkj.huatuweitong.utlis.MoneyUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * 推荐车型 adapter
 * Created by cdkj on 2018/4/9.
 */

public class RecommendCarAdapter extends BaseQuickAdapter<FirstPageCarRecommendBean, BaseViewHolder> {

    private Object obj;//这个其实是上下文

    public RecommendCarAdapter(@Nullable List<FirstPageCarRecommendBean> data, Object obj) {
        super(R.layout.item_recommend_car, data);
        SoftReference<Object> mS = new SoftReference<>(obj);
        this.obj = mS.get();
    }

    @Override
    protected void convert(BaseViewHolder helper, FirstPageCarRecommendBean item) {
        if (item == null) return;
        helper.setText(R.id.tv_down_payments, "首付"+ MoneyUtils.BigDecimalToString(item.getPrice()));

        helper.setText(R.id.tv_title,item.getName());
        ImageView imageView=helper.getView(R.id.iv_src);
        ImgUtils.loadQiniuImg(obj,item.getAdvPic(),imageView);
    }
}
