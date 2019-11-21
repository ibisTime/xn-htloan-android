package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.BrandBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @updateDts 2019/3/13
 */
public class BrandHorAdapter extends BaseQuickAdapter<BrandBean, BaseViewHolder> {
    public BrandHorAdapter(@Nullable List<BrandBean> data) {
        super(R.layout.item_brand_hor_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BrandBean item) {
        ImgUtils.loadQiniuImg(mContext,item.getLogo(),helper.getView(R.id.iv_brand_img));
        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.tv_brand_name, item.getName());
        } else {
            helper.setText(R.id.tv_brand_name, "");
        }

        helper.setText(R.id.tv_sort, item.getLetter());

        if (helper.getLayoutPosition() == 0){
            helper.setGone(R.id.ll_sort, true);
        }else {
            if (!item.getLetter().equals(getData().get(helper.getLayoutPosition()-1).getLetter())){
                helper.setGone(R.id.ll_sort, true);
            }else {
                helper.setGone(R.id.ll_sort, false);
            }
        }

    }

    public int getPositionBySort(String sort) {
        if (sort.equals("#"))
            return 0;

        for (int i = 0; i < getData().size(); i++) {
            String sortStr = getData().get(i).getLetter();
            if (sortStr.equals(sort)) {
                return i;
            }
        }
        return -1;
    }

    public int getSortPosition(String sort) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < getData().size(); i++) {

            String sortStr = getData().get(i).getLetter();

            if (sortStr.equals(sort)) {
                break;
            }

            if (!list.contains(sortStr)){
                list.add(sortStr);
            }



        }

        return list.size();
    }
}
