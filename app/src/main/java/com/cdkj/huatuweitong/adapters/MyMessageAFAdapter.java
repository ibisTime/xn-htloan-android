package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.bean.MyMessageAFBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/19
 * Created by lenovo on 2018/5/19.
 */

public class MyMessageAFAdapter extends BaseQuickAdapter<MyMessageAFBean,BaseViewHolder> {
    public MyMessageAFAdapter(int layoutResId, @Nullable List<MyMessageAFBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyMessageAFBean item) {

        //判断上个条目和下个条目的时间是否一致  一致就不显示  不一致就显示

    }
}
