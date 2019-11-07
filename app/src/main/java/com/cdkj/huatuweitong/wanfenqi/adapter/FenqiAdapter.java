package com.cdkj.huatuweitong.wanfenqi.adapter;

import android.support.annotation.Nullable;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.MainResourceBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author : qianLei
 * @since : 2019/11/4 15:46
 */
public class FenqiAdapter extends BaseQuickAdapter<MainResourceBean.ListBean, BaseViewHolder> {

    public FenqiAdapter(@Nullable List<MainResourceBean.ListBean> data) {
        super(R.layout.item_fenqi, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainResourceBean.ListBean item) {

        helper.setText(R.id.tv_title, item.getName());
        helper.setText(R.id.tv_info, item.getSynopsis());

    }
}
