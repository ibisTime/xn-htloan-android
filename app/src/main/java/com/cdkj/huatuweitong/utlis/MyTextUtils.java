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
    
//    public  static  void setStatusType004(TextView view, String status){
//        if (TextUtils.equals("1", status)) {
//            //已还完
//            view.setText( "已完成");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("0".equals(status)) {
//            view.setText( "还款中");
//            view.setTextColor( ColorUtils.blue());
//        }else if ("2".equals(status)) {
//            view.setText( "正常结清");
//            view.setTextColor( ColorUtils.textGary());
//        }else if ("3".equals(status)) {
//            view.setText( "提前还款");
//            view.setTextColor(ColorUtils.textGary());
//        }else if ("4".equals(status)) {
//            view.setText( "确认提前结清");
//            view.setTextColor(ColorUtils.textGary());
//        }else if ("5".equals(status)) {
//            view.setText( "确认不还");
//            view.setTextColor( ColorUtils.textGary());
//        }else if ("6".equals(status)) {
//            view.setText( "确认处理结果");
//            view.setTextColor( ColorUtils.textGary());
//        }
//    }

    public  static  void setStatusType003(TextView view, String status){
        if (TextUtils.equals("003_01", status)) {
            view.setText( "还款中");
            view.setTextColor(ColorUtils.textGary());
        } else if ("003_02".equals(status)) {
            view.setText( "清欠催收部审核");
            view.setTextColor( ColorUtils.blue());
        }else if ("003_03".equals(status)) {
            view.setText( "驻行人员审核");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_04".equals(status)) {
            view.setText( "总经理审核");
            view.setTextColor(ColorUtils.textGary());
        }else if ("003_05".equals(status)) {
            view.setText( "财务审核");
            view.setTextColor(ColorUtils.textGary());
        }else if ("003_06".equals(status)) {
            view.setText( "解除抵押");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_07".equals(status)) {
            view.setText( "已完成");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_08".equals(status)) {
            view.setText( "清款催收部申请拖车");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_09".equals(status)) {
            view.setText( "财务打款");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_10".equals(status)) {
            view.setText( "清款催收部拖车");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_11".equals(status)) {
            view.setText( "清款催收部已拖车");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_12".equals(status)) {
            view.setText( "待用户赎回");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_13".equals(status)) {
            view.setText( "司法诉讼");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_14".equals(status)) {
            view.setText( "坏账");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_15".equals(status)) {
            view.setText( "业务团队买断");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_16".equals(status)) {
            view.setText( "业务团队租赁");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_17".equals(status)) {
            view.setText( "清款催收部申请赎回");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_18".equals(status)) {
            view.setText( "风控主管审核");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_19".equals(status)) {
            view.setText( "财务经理审核");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_20".equals(status)) {
            view.setText( "风控主管审核不通过");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_21".equals(status)) {
            view.setText( "财务经理审核不通过");
            view.setTextColor( ColorUtils.textGary());
        }else if ("003_22".equals(status)) {
            view.setText( "结清剩余还款");
            view.setTextColor( ColorUtils.textGary());
        }
    }

    public  static  void setStatusType004(TextView view, String status){
        if (TextUtils.equals("004_01", status)) {
            view.setText( "待还款");
            view.setTextColor(ColorUtils.textGary());
        } else if ("004_02".equals(status)) {
            view.setText( "已还款");
            view.setTextColor( ColorUtils.blue());
        }else if ("004_03".equals(status)) {
            view.setText( "已逾期待处理");
            view.setTextColor( ColorUtils.textGary());
        }else if ("004_04".equals(status)) {
            view.setText( "缴纳违约押金，进绿名单");
            view.setTextColor(ColorUtils.textGary());
        }else if ("004_05".equals(status)) {
            view.setText( "已代偿，进黄名单");
            view.setTextColor(ColorUtils.textGary());
        }else if ("004_06".equals(status)) {
            view.setText( "催收失败，进红名单处理");
            view.setTextColor( ColorUtils.textGary());
        }else if ("004_07".equals(status)) {
            view.setText( "红名单处理中");
            view.setTextColor( ColorUtils.textGary());
        }
    }

}
