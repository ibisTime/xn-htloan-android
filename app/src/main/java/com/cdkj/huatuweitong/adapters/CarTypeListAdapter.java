package com.cdkj.huatuweitong.adapters;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.DisplayHelper;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarBean;
import com.cdkj.huatuweitong.bean.CarSelectPageBean;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.cdkj.huatuweitong.module.vehicle_db.CarDetailsActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayout;

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
        helper.setText(R.id.tv_product_title, item.getName());

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

        helper.setGone(R.id.tv_config, false);

//        FlexboxLayout flexLayout = helper.getView(R.id.flex_layout);
//        flexLayout.removeAllViews();
//        helper.setGone(R.id.flex_layout, !TextUtils.isEmpty(item.getConfigName()));
//        for (String s : item.getConfigName().split("  ")) {
//
//            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
//                    FlexboxLayout.LayoutParams.WRAP_CONTENT,
//                    DisplayHelper.dp2px(mContext, 25));
//            layoutParams.bottomMargin = 10;
//            layoutParams.rightMargin = 10;
//            TextView textView = createText(s);
//
//            flexLayout.addView(textView, layoutParams);
//
//        }

    }

    /**
     * 根据文本创建TextView用于显示助记词
     *
     * @param word
     */
    public TextView createText(String word) {

        TextView textView = new TextView(mContext);
        textView.setText("  " + word + "  ");
        textView.setTextSize(12f);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.parseColor("#666666"));
        textView.setBackgroundResource(R.drawable.shape_car_config);
        textView.setPadding(10, 0,
                10, 0);

        return textView;

    }

}
