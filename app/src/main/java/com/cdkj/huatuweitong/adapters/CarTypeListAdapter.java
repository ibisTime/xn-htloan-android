package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarBean;
import com.cdkj.huatuweitong.bean.CarSelectPageBean;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class CarTypeListAdapter extends BaseQuickAdapter<CarBean, BaseViewHolder> {

    public CarTypeListAdapter(@Nullable List<CarBean> data) {
        super(R.layout.item_car_list, data);//因为数据不全暂时先展示这个
    }

    @Override
    protected void convert(BaseViewHolder helper, CarBean item) {
        ImgUtils.loadQiniuImg(mContext, item.getPic(), helper.getView(R.id.img_product));
        helper.setText(R.id.tv_product_title,
                item.getBrandName() + "  " + item.getSeriesName() + "  " + item.getName());

        String type = "";
        if (item.getLevel() != null) {
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
        }

        helper.setText(R.id.tv_type, type);
        helper.setText(R.id.tv_date,
                DateUtil.formatStringData(item.getUpdateDatetime(), DateUtil.DATE_YMD));
        helper.setText(R.id.tv_price, MoneyUtils.formatNum(item.getSalePrice()));

        helper.setGone(R.id.tv_slogan, !TextUtils.isEmpty(item.getConfigName()));
        helper.setText(R.id.tv_slogan, item.getConfigName());

    }
}
