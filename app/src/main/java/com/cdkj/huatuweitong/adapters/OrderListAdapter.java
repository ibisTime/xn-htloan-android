package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.OrderBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * 推荐产品 adapter
 * Created by cdkj on 2018/4/9.
 */

public class OrderListAdapter extends BaseQuickAdapter<OrderBean, BaseViewHolder> {

    private Object obj;

    public OrderListAdapter(@Nullable List<OrderBean> data, Object obj) {
        super(R.layout.item_order, data);
        SoftReference<Object> mS = new SoftReference<>(obj);
        this.obj = mS.get();
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean item) {
        if (item == null) return;

        helper.setText(R.id.txt_orderId, item.getCode());
        helper.setText(R.id.txt_state, getOrderStateString(item.getStatus()));

        if (item.getProductOrderList() != null && item.getProductOrderList().size() > 0 && item.getProductOrderList().get(0).getProduct() != null) {
                helper.setText(R.id.tv_name, item.getProductOrderList().get(0).getProduct().getName());
                helper.setText(R.id.tv_price_all, MoneyUtils.showPrice(item.getProductOrderList().get(0).getPrice()));
                ImgUtils.loadQiniuImg(this.obj, item.getProductOrderList().get(0).getProduct().getAdvPic(), helper.getView(R.id.img_good));
                helper.setText(R.id.tv_spec, item.getProductOrderList().get(0).getProductSpecsName());
        }


    }

    private String getOrderStateString(String status) {
        switch (status) {
            case "1":
                return "待支付";
            case "3":
                return "待发货";
            case "2":
                return "还款中";

        }
        return "";
    }


}
