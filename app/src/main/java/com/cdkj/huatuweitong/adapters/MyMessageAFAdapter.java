package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
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

        //判断上个条目和下个条目的时间是否一致  一致就不显示  不一致就显示

//        tv_time//时间
//                tv_title //标题
//        tv_content//内容
//                ll_money

        TextView tv_time = helper.getView(R.id.tv_time);
        TextView tv_title = helper.getView(R.id.tv_title);
        TextView tv_content = helper.getView(R.id.tv_content);
        tv_time.setText(item.getPushedDatetime());
        String time = DateUtil.formatStringData(item.getPushedDatetime(), DateUtil.DATE_YMD);
        tv_time.setText(time);
        tv_title.setText(item.getSmsTitle());
        tv_content.setText(item.getSmsContent());

        LinearLayout ll_money = helper.getView(R.id.ll_money);//查看更多
        ll_money.setVisibility(View.GONE);

    }
}
