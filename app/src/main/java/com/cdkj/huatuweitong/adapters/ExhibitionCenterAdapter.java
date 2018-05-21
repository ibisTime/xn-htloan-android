package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.ExhibitionCenterBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/16
 * Created by lenovo on 2018/5/16.
 */

public class ExhibitionCenterAdapter extends BaseQuickAdapter<ExhibitionCenterBean, BaseViewHolder> {


    public ExhibitionCenterAdapter(@Nullable List<ExhibitionCenterBean> data) {
        super(R.layout.item_exhibition_center, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ExhibitionCenterBean item) {
//        helper.setText(R.id.tv_name,)
//        tv_name
//                tv_price
//        tv_month
//                iv_logo

        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_type_name, item.getSeriesName());
        helper.setText(R.id.tv_price, "总价" + MoneyUtils.showPriceDouble(item.getSalePrice()) + "元");

        helper.setText(R.id.tv_first_pay, "首付: " + MoneyUtils.showPriceDouble(item.getSfAmount())  + "元");
        ImageView imgLogo = helper.getView(R.id.iv_logo);
        ImgUtils.loadQiniuImg(mContext,item.getPic(),imgLogo);
    }
}
