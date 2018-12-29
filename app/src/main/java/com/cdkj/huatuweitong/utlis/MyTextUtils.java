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

    /**
     * 还款业务：  全部借款
     * 还款中：003_01，003_17，003_18，003_19，005_01
     * 结清中：003_02，003_03，003_04，003_05，003_06，003_20，005_02
     * 已结清：003_07，005_03
     * 已逾期：003_08，003_09，003_10，003_11，003_13，003_14，003_15，003_16，005_04
     * <p>
     * 还款计划：  本月应还  近期还款
     * 还款中：004_01，004_04，004_05，006_01，006_06，006_04
     * 已还款：004_02，006_02
     * 已逾期：004_03，004_06，004_07，004_08，004_09，004_10，006_05，006_03
     *
     * @param view
     * @param status
     */
    public static void setStatusTypeAll(TextView view, String status) {
        if (TextUtils.equals("003_01", status) || TextUtils.equals("003_17", status) || TextUtils.equals("003_18", status) ||
                TextUtils.equals("003_19", status) || TextUtils.equals("005_01", status) || TextUtils.equals("004_01", status) ||
                TextUtils.equals("004_04", status) || TextUtils.equals("004_05", status) ||
                TextUtils.equals("006_01", status) || TextUtils.equals("006_06", status) || TextUtils.equals("006_04", status)) {
            view.setText("还款中");
            view.setTextColor(ColorUtils.blue());
        } else if (TextUtils.equals("004_02", status) || TextUtils.equals("006_02", status)) {
            view.setText("已还款");
            view.setTextColor(ColorUtils.blue());
        } else if (TextUtils.equals("003_02", status) || TextUtils.equals("003_03", status) || TextUtils.equals("003_04", status) ||
                TextUtils.equals("003_05", status) || TextUtils.equals("003_06", status) || TextUtils.equals("003_20", status) ||
                TextUtils.equals("005_02", status)) {
            view.setText("结清中");
            view.setTextColor(ColorUtils.blue());
        } else if (TextUtils.equals("003_07", status) || TextUtils.equals("005_03", status)) {
            view.setText("已结清");
            view.setTextColor(ColorUtils.blue());
        } else {
            view.setText("已逾期");
            view.setTextColor(ColorUtils.textGary());
        }
    }

//    public static void setStatusTypeJQ(TextView view, String status) {
//
//        if (TextUtils.equals("004_01", status) || TextUtils.equals("004_04", status) || TextUtils.equals("004_05", status) ||
//                TextUtils.equals("006_01", status) || TextUtils.equals("006_06", status) || TextUtils.equals("006_04", status)) {
//            view.setText("还款中");
//            view.setTextColor(ColorUtils.textGary());
//        } else if (TextUtils.equals("003_02", status) || TextUtils.equals("003_03", status) || TextUtils.equals("003_04", status) ||
//                TextUtils.equals("003_05", status) || TextUtils.equals("003_06", status) || TextUtils.equals("003_20", status) ||
//                TextUtils.equals("005_02", status)) {
//            view.setText("结清中");
//            view.setTextColor(ColorUtils.blue());
//        } else if (TextUtils.equals("003_07", status) || TextUtils.equals("005_03", status)) {
//            view.setText("已结清");
//            view.setTextColor(ColorUtils.blue());
//        } else {
//            view.setText("已逾期");
//            view.setTextColor(ColorUtils.textGary());
//        }
//    }

//    public static void setStatusType003(TextView view, String status) {
//        if (TextUtils.equals("003_01", status)) {
//            view.setText("还款中");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_02".equals(status)) {
//            view.setText("清欠催收部审核");
//            view.setTextColor(ColorUtils.blue());
//        } else if ("003_03".equals(status)) {
//            view.setText("驻行人员审核");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_04".equals(status)) {
//            view.setText("总经理审核");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_05".equals(status)) {
//            view.setText("财务审核");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_06".equals(status)) {
//            view.setText("解除抵押");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_07".equals(status)) {
//            view.setText("已完成");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_08".equals(status)) {
//            view.setText("清款催收部申请拖车");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_09".equals(status)) {
//            view.setText("财务打款");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_10".equals(status)) {
//            view.setText("清款催收部拖车");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_11".equals(status)) {
//            view.setText("清款催收部已拖车");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_12".equals(status)) {
//            view.setText("待用户赎回");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_13".equals(status)) {
//            view.setText("司法诉讼");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_14".equals(status)) {
//            view.setText("坏账");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_15".equals(status)) {
//            view.setText("业务团队买断");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_16".equals(status)) {
//            view.setText("业务团队租赁");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_17".equals(status)) {
//            view.setText("清款催收部申请赎回");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_18".equals(status)) {
//            view.setText("风控主管审核");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_19".equals(status)) {
//            view.setText("财务经理审核");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_20".equals(status)) {
//            view.setText("风控主管审核不通过");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_21".equals(status)) {
//            view.setText("财务经理审核不通过");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("003_22".equals(status)) {
//            view.setText("结清剩余还款");
//            view.setTextColor(ColorUtils.textGary());
//        }
//        //下面是  不走预算单的节点
////        STARTNODE("005_00", "开始节点"), APPLY("005_01", "提交请款预算单"), AUDIT("005_02",
////                "财务经理审核"), LOAN("005_03", "确认放款"), REFILL("005_04", "重新填写请款预算单"), ALREADY_CREDIT(
////                "005_05", "已放款"), COLLECTION("005_06", "财务确认收回预算款");
//        else if ("005_01".equals(status)) {
//            view.setText("提交请款预算单");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("005_02".equals(status)) {
//            view.setText("财务经理审核");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("005_03".equals(status)) {
//            view.setText("确认放款");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("005_04".equals(status)) {
//            view.setText("重新填写请款预算单");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("005_05".equals(status)) {
//            view.setText("已放款");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("005_06".equals(status)) {
//            view.setText("财务确认收回预算款");
//            view.setTextColor(ColorUtils.textGary());
//        }
//    }
//
//    public static void setStatusType004(TextView view, String status) {
//        if (TextUtils.equals("004_01", status)) {
//            view.setText("待还款");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("004_02".equals(status)) {
//            view.setText("已还款");
//            view.setTextColor(ColorUtils.blue());
//        } else if ("004_03".equals(status)) {
//            view.setText("已逾期待处理");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("004_04".equals(status)) {
//            view.setText("缴纳违约押金，进绿名单");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("004_05".equals(status)) {
//            view.setText("已代偿，进黄名单");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("004_06".equals(status)) {
//            view.setText("催收失败，进红名单处理");
//            view.setTextColor(ColorUtils.textGary());
//        } else if ("004_07".equals(status)) {
//            view.setText("红名单处理中");
//            view.setTextColor(ColorUtils.textGary());
//        }
//
//        //{"code":"006_01","name":"待还款","type":"006"},{"code":"006_02","name":"已还款","type":"006"},{"code":"006_03","name":"已逾期待处理","type":"006"},{"code":"006_04","name":"逾期处理，进绿名单","type":"006"},{"code":"006_05","name":"不还，进黑名单","type":"006"},{"code":"006_06","name":"还款审核","type":"006"}
//        if (TextUtils.equals("006_01", status)) {
//            view.setText("待还款");
//            view.setTextColor(ColorUtils.textGary());
//        } else if (TextUtils.equals("006_02", status)) {
//            //完成
//            view.setText("已还款");
//            view.setTextColor(ColorUtils.blue());
//        } else if (TextUtils.equals("006_06", status)) {
//            //完成
//            view.setText("还款审核");
//            view.setTextColor(ColorUtils.blue());
//        } else {
//            //逾期
//            view.setText("逾期");
//            view.setTextColor(ColorUtils.textGary());
//        }
//    }

//    public static void setStatusTypeAll(TextView view, String status) {
//        if (MainActivity.nodeModellist != null) {
//            for (NodeModel mode : MainActivity.nodeModellist) {
//                if (TextUtils.equals(mode.getCode(), status)) {
//                    view.setText(mode.getName() == null ? "" : mode.getName());
//                    break;
//                }
//            }
//        }
//    }

}
