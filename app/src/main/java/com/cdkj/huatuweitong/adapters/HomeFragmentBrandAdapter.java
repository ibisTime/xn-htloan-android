package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.BrandBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/14
 */
public class HomeFragmentBrandAdapter extends BaseQuickAdapter<BrandBean, BaseViewHolder> {
    public HomeFragmentBrandAdapter(@Nullable List<BrandBean> data) {
        super(R.layout.item_home_brand_fragment, data);
//        item_home_brand_fragment
    }

    @Override
    protected void convert(BaseViewHolder helper, BrandBean item) {
        int position = helper.getPosition();
        if (position % 4 == 0 || mData.size() - 1 == position) {
            //如果是  最右面一个条目就不显示这个分割线
            helper.setGone(R.id.tv_lien, true);
        } else {
            helper.setVisible(R.id.tv_lien, true);
        }
        helper.setText(R.id.tv_brand_name, item.getName());
        ImgUtils.loadQiniuImg(mContext, item.getLogo(), helper.getView(R.id.iv_brand_img));
    }
}
