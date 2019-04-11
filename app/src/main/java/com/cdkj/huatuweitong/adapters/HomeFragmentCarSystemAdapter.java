package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Arrays;
import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class HomeFragmentCarSystemAdapter extends BaseQuickAdapter<CarSystemListBean, BaseViewHolder> {
    public HomeFragmentCarSystemAdapter(@Nullable List<CarSystemListBean> data) {
        super(R.layout.item_brand_ver_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarSystemListBean item) {
        helper.setText(R.id.tv_brand_name, item.getName());

        String[] split = item.getAdvPic().split("\\|\\|");
        List<String> strings = Arrays.asList(split);
        if (strings.size() > 0) {
            ImgUtils.loadQiniuImg(mContext, strings.get(0), helper.getView(R.id.iv_brand_img));
        }

    }
}
