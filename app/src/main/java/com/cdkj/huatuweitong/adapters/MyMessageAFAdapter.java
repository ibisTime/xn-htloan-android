package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.MsgListModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/19
 * Created by lenovo on 2018/5/19.
 */

public class MyMessageAFAdapter extends BaseQuickAdapter<MsgListModel.ListBean, BaseViewHolder> {
    public MyMessageAFAdapter(@Nullable List<MsgListModel.ListBean> data) {
        super(R.layout.item_my_message_a_f, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MsgListModel.ListBean item) {

        TextView tvState = helper.getView(R.id.tv_state);
        if (TextUtils.equals(item.getIsAlreadyRead(), "0")){
            tvState.setText("未读");
            tvState.setBackgroundResource(R.drawable.bg_user_message_un);
        }else if (TextUtils.equals(item.getStatus(), "1")){
            tvState.setText("已读");
            tvState.setBackgroundResource(R.drawable.bg_user_message);
        }

        TextView tv_time = helper.getView(R.id.tv_time);
        TextView tv_title = helper.getView(R.id.tv_title);
        TextView tv_content = helper.getView(R.id.tv_content);
        String time = DateUtil.formatStringData(item.getUpdateDatetime(), DateUtil.DEFAULT_DATE_FMT);
        tv_time.setText(time);
        tv_title.setText(item.getTitle());

        tv_content.setText(item.getContent());

    }
}
