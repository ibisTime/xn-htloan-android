package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.widget.RatingBar;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * 推荐车型 adapter
 * Created by cdkj on 2018/4/9.
 */

public class RecommendCarAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private Object obj;

    public RecommendCarAdapter(@Nullable List<String> data, Object obj) {
        super(R.layout.item_recommend_car, data);
        SoftReference<Object> mS = new SoftReference<>(obj);
        this.obj = mS.get();
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (item == null) return;

    }
}
