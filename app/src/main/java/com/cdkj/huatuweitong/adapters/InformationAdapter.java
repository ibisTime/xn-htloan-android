package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.InformationBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class InformationAdapter extends BaseQuickAdapter<InformationBean.ListBean, BaseViewHolder> {

    public InformationAdapter(@Nullable List<InformationBean.ListBean> data) {
        super(R.layout.item_information, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InformationBean.ListBean item) {
        ImgUtils.loadQiniuImg(mContext, item.getPic(), helper.getView(R.id.img_product));
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_mouth_money, item.getReadCount() + "次浏览");
        helper.setText(R.id.tv_author, item.getAuthor());
        helper.setText(R.id.tv_tag, item.getTag());
    }
}

