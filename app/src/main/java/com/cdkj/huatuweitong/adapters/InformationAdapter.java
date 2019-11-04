package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.DataDictionaryBean;
import com.cdkj.huatuweitong.bean.InformationListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class InformationAdapter extends BaseQuickAdapter<InformationListBean.ListBean, BaseViewHolder> {

    private List<DataDictionaryBean> list;

    public InformationAdapter(@Nullable List<InformationListBean.ListBean> data, List<DataDictionaryBean> list) {
        super(R.layout.item_information, data);
        this.list = list;
    }

    @Override
    protected void convert(BaseViewHolder helper, InformationListBean.ListBean item) {
        ImgUtils.loadQiniuImg(mContext, item.getPic(), helper.getView(R.id.img_product));
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_mouth_money, item.getReadCount() + "次浏览");
        helper.setText(R.id.tv_author, item.getAuthor());

        for (DataDictionaryBean dictionaryBean : list) {
            if (dictionaryBean.getDkey().equals(item.getTag())){
                helper.setText(R.id.tv_tag, dictionaryBean.getDvalue());
            }

        }
    }
}

