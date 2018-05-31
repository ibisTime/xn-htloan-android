package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.CarBrandActivityBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class CarBrandAdapter extends BaseQuickAdapter<CarBrandActivityBean, BaseViewHolder> {
    public CarBrandAdapter(@Nullable List<CarBrandActivityBean> data) {
        super(R.layout.item_car_brand, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarBrandActivityBean item) {
        helper.setText(R.id.tv_name, item.getName());
    }
}
