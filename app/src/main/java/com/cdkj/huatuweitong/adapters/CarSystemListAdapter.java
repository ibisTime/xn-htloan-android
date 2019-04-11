package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Arrays;
import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class CarSystemListAdapter extends BaseQuickAdapter<CarSystemListBean, BaseViewHolder> {

    public CarSystemListAdapter(@Nullable List<CarSystemListBean> data) {
        super(R.layout.item_car_system_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarSystemListBean item) {

        String[] split = item.getAdvPic().split("\\|\\|");
        List<String> strings = Arrays.asList(split);
        if (strings.size() > 0) {
            ImgUtils.loadQiniuImg(mContext, strings.get(0), helper.getView(R.id.img_product));
        }
//        ImgUtils.loadQiniuImg(mContext, item.getAdvPic(), helper.getView(R.id.img_product));
        helper.setText(R.id.tv_product_title, item.getName());
        String type = "";
        switch (item.getLevel()) {
            case "0":
                type = "SUV";
                break;
            case "1":
                type = "轿车";
                break;
            case "2":
                type = "MPV";
                break;
            case "3":
                type = "跑车";
                break;
            case "4":
                type = "皮卡";
                break;
            case "5":
                type = "房车";
                break;
        }
//        item.getOutsideColor
        helper.setText(R.id.tv_type, type);
        helper.setText(R.id.tv_price, MoneyUtils.formatNum(item.getLowest()) + "元-" + MoneyUtils.formatNum(item.getHighest()) + "元");
    }
}
