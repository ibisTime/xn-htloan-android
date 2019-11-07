package com.cdkj.huatuweitong.module.user.message.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
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

public class UserMessageAdapter extends BaseQuickAdapter<MsgListModel.ListBean, BaseViewHolder> {

    public UserMessageAdapter(@Nullable List<MsgListModel.ListBean> data) {
        super(R.layout.item_my_message, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MsgListModel.ListBean item) {

        if (TextUtils.equals(item.getIsAlreadyRead(), "0")) {
            helper.setGone(R.id.tv_status, true);
            helper.setTextColor(R.id.tv_name, Color.parseColor("#333333"));
        } else if (TextUtils.equals(item.getStatus(), "1")) {
            helper.setGone(R.id.tv_status, false);
            helper.setTextColor(R.id.tv_name, Color.parseColor("#999999"));
        }

        if (item.getType().equals("1")) {
            helper.setBackgroundRes(R.id.iv_logo, R.mipmap.user_msg_gonggao);
        } else {
            helper.setBackgroundRes(R.id.iv_logo, R.mipmap.user_msg_tongzhi);
        }

        TextView tv_title = helper.getView(R.id.tv_name);
        tv_title.setText(item.getTitle());

        TextView tv_time = helper.getView(R.id.tv_time);
        tv_time.setText(
                DateUtil.formatStringData(item.getUpdateDatetime(), DateUtil.DEFAULT_DATE_FMT));
    }
}
