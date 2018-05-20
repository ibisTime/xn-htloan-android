package com.cdkj.huatuweitong.other;

import android.text.TextUtils;

import com.cdkj.huatuweitong.BaseApplication;
import com.cdkj.huatuweitong.R;

/**
 * Created by cdkj on 2018/5/19.
 */

public class OrderHelper {

    /*@mock= TO_PAY("1", "待支付"), PAY_YES("2", "已支付"), SEND("4", "已发货"), RECEIVE("5", "已收货"), COMMENT("6", "已评论"),
    YHYC("91", "用户异常"), SHYC("92", "商户异常"), KDYC("93", "快递异常"), RECYCLE("94", "用户删除")*/
    public enum ORDER_STATE {

        TO_PAY("1", "待支付"), PAY_YES("2", "已支付"), SEND("4", "已发货"), RECEIVE("5", "已收货"), COMMENT("6", "已评论"),
        YHYC("91", "已取消"), SHYC("92", "已取消"), KDYC("93", "已取消"), RECYCLE("94", "用户删除");

        private String name;
        private String state;

        ORDER_STATE(String state, String name) {
            this.name = name;
            this.state = state;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }


        /**
         * 根据类型的名称，返回类型的枚举实例。
         *
         * @param state 类型名称
         */
        public static String fromTypeName(String state) {
            for (ORDER_STATE type : ORDER_STATE.values()) {
                if (type.getState().equals(state)) {
                    return type.getName();
                }
            }
            return "";
        }
    }

    /**
     * 能否显示订单取消按钮
     *
     * @param state
     * @return
     */
    public static boolean canShowOrderCancelBtn(String state) {
        return TextUtils.equals(state, OrderHelper.ORDER_STATE.TO_PAY.getState());
    }

    /**
     * 能否显示订单状态对应操作按钮
     *
     * @param state
     * @return
     */
    public static boolean canShowOrderStateDoBtn(String state) {
        return TextUtils.equals(state, OrderHelper.ORDER_STATE.TO_PAY.getState());
    }

    /**
     * 获取订单状态操作
     *
     * @param state
     * @return
     */
    public static String getOrderStateDoBtnString(String state) {
        if (TextUtils.equals(state, OrderHelper.ORDER_STATE.TO_PAY.getState())) {
            return "前往支付";
        }

        if (TextUtils.equals(state, OrderHelper.ORDER_STATE.SEND.getState())) {
            return "确认收货";
        }
        return "";
    }

}
