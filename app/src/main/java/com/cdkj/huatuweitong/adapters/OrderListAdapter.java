package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.MoneyUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.OrderBean;
import com.cdkj.huatuweitong.other.OrderHelper;
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
        helper.setText(R.id.txt_state, OrderHelper.ORDER_STATE.fromTypeName(item.getStatus()));
        helper.setText(R.id.tv_order_state, OrderHelper.getOrderStateDoBtnString(item.getStatus()));
        helper.setText(R.id.tv_price_all, MoneyUtils.showPrice(item.getAmount()));
        if (item.getProductOrderList() != null && item.getProductOrderList().size() > 0 && item.getProductOrderList().get(0).getProduct() != null) {
            helper.setText(R.id.tv_name, item.getProductOrderList().get(0).getProduct().getName());

            ImgUtils.loadQiniuImg(this.obj, item.getProductOrderList().get(0).getProduct().getAdvPic(), helper.getView(R.id.img_good));
            helper.setText(R.id.tv_spec, item.getProductOrderList().get(0).getProductSpecsName());
        }

        helper.addOnClickListener(R.id.tv_cancel_order);
        helper.addOnClickListener(R.id.tv_order_state);

        helper.setGone(R.id.tv_cancel_order, OrderHelper.canShowOrderCancelBtn(item.getStatus()));
        helper.setGone(R.id.tv_order_state, OrderHelper.canShowOrderStateDoBtn(item.getStatus()));

    }


}
