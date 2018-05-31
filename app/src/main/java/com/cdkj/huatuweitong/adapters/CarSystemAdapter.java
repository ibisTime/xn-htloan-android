package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarSystemActivityBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class CarSystemAdapter extends BaseQuickAdapter<CarSystemActivityBean, BaseViewHolder> {
    public CarSystemAdapter(@Nullable List<CarSystemActivityBean> data) {
        super(R.layout.item_car_brand, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarSystemActivityBean item) {
        helper.setText(R.id.tv_name, item.getName());
    }
}
