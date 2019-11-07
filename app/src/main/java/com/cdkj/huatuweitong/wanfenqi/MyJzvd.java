package com.cdkj.huatuweitong.wanfenqi;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import cn.jzvd.JzvdStd;
import com.cdkj.huatuweitong.bean.ResourceVisitNumBean;
import org.greenrobot.eventbus.EventBus;

/**
 * @author : qianLei
 * @since : 2019/11/6 15:02
 */
public class MyJzvd extends JzvdStd {

    public MyJzvd(Context context) {
        super(context);
    }

    public MyJzvd(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onStatePlaying() {
        super.onStatePlaying();

//        Log.e("onStatePlaying",getTag()+"");
//        Log.e("onStatePlaying","onStatePlaying");
    }

    @Override
    public void onStatePreparing() {
        super.onStatePreparing();

        EventBus.getDefault().post(new ResourceVisitNumBean().setCode(getTag().toString()));

    }
}
