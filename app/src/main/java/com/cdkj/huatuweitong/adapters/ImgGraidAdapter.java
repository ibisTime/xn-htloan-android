package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class ImgGraidAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ImgGraidAdapter(@Nullable List<String> data) {
        super(R.layout.item_img_activity, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImgUtils.loadImg(mContext, MyCdConfig.QINIUURL+item, helper.getView(R.id.iv_img));

    }
}
