package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarModelActivityBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class CarModelAdapter extends BaseQuickAdapter<CarModelActivityBean.CarsBean, BaseViewHolder> {
    public CarModelAdapter(@Nullable List<CarModelActivityBean.CarsBean> data) {
        super(R.layout.item_car_brand, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarModelActivityBean.CarsBean item) {
        helper.setText(R.id.tv_name, item.getName());
    }
}
