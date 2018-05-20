package com.cdkj.huatuweitong.utlis;

import android.text.TextUtils;
import android.widget.TextView;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/20
 * Created by lenovo on 2018/5/20.
 */

public class MyTextUtils {
    
    public  static  void setStatusType(TextView view, String status){
        if (TextUtils.equals("1", status)) {
            //已还完
            view.setText( "已完成");
            view.setTextColor(ColorUtils.textGary());
        } else if ("0".equals(status)) {
            view.setText( "还款中");
            view.setTextColor( ColorUtils.blue());
        }else if ("2".equals(status)) {
            view.setText( "正常结清");
            view.setTextColor( ColorUtils.textGary());
        }else if ("3".equals(status)) {
            view.setText( "提前还款");
            view.setTextColor(ColorUtils.textGary());
        }else if ("4".equals(status)) {
            view.setText( "确认提前结清");
            view.setTextColor(ColorUtils.textGary());
        }else if ("5".equals(status)) {
            view.setText( "确认不还");
            view.setTextColor( ColorUtils.textGary());
        }else if ("6".equals(status)) {
            view.setText( "确认处理结果");
            view.setTextColor( ColorUtils.textGary());
        }
    }

}
