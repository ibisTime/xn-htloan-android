package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.MyCollectionBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @updateDts 2019/3/14
 */
public class MyCollectionAdapter extends BaseQuickAdapter<MyCollectionBean.ListBean, BaseViewHolder> {
    public MyCollectionAdapter(@Nullable List<MyCollectionBean.ListBean> data) {
        super(R.layout.item_car_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCollectionBean.ListBean item) {
        //设置选中状态
        helper.setGone(R.id.cb_select, item.isShowSelect());
        helper.setChecked(R.id.cb_select, item.isSelect());
        helper.addOnClickListener(R.id.cb_select);


        MyCollectionBean.ListBean.CarBean car = item.getCar();
        if (car == null)
            return;
        ImgUtils.loadQiniuImg(mContext, car.getPic(), helper.getView(R.id.img_product));

        helper.setText(R.id.tv_product_title, car.getName());
        helper.setText(R.id.tv_type, car.getSlogan());
        helper.setText(R.id.tv_date, DateUtil.formatStringData(car.getUpdateDatetime(), DateUtil.DATE_YMD));
        helper.setText(R.id.tv_price, car.getSalePrice() + "");
        List<MyCollectionBean.ListBean.CarBean.CaonfigListBean> caonfigList = car.getCaonfigList();
        StringBuilder sb = new StringBuilder();
        if (caonfigList != null && caonfigList.size() != 0) {
            for (int i = 0; i < caonfigList.size(); i++) {
                MyCollectionBean.ListBean.CarBean.CaonfigListBean.ConfigBean caonfigListBean = caonfigList.get(i).getConfig();
                if (caonfigListBean != null) {
                    sb.append(caonfigListBean.getName());
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            helper.setText(R.id.tv_slogan, sb.toString());
        }

    }
}
