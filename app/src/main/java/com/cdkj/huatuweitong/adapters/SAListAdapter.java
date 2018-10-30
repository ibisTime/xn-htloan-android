package com.cdkj.huatuweitong.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.SAListBean;
import com.cdkj.huatuweitong.databinding.ItemSaListActivityBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class SAListAdapter extends BaseQuickAdapter<SAListBean.DataBean, BaseViewHolder> {

    private ItemSaListActivityBinding mBinding;

    public SAListAdapter(@Nullable List<SAListBean.DataBean> data) {
        super(R.layout.item_sa_list_activity, data);
        //因为数据不全暂时先展示这个
    }

    @Override
    protected void convert(BaseViewHolder helper, SAListBean.DataBean item) {
        mBinding = DataBindingUtil.bind(helper.itemView);
        mBinding.tvTitle.setText(item.getTitle());
        mBinding.tvDangshiren.setText(item.getDangshiren());
        mBinding.tvJsummary.setText(item.getJsummary());
    }
}
