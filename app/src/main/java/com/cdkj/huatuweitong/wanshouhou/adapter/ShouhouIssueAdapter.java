package com.cdkj.huatuweitong.wanshouhou.adapter;

import android.support.annotation.Nullable;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.wanshouhou.bean.ShouhouIssueBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author : qianLei
 * @since : 2019/11/4 17:01
 */
public class ShouhouIssueAdapter extends
        BaseQuickAdapter<ShouhouIssueBean.ListBean, BaseViewHolder> {

    public ShouhouIssueAdapter(@Nullable List<ShouhouIssueBean.ListBean> data) {
        super(R.layout.item_shouhou_issue, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShouhouIssueBean.ListBean item) {

        helper.setText(R.id.tv_title, item.getInquiry());
        helper.setText(R.id.tv_answer, item.getAnswer());

    }
}
