package com.cdkj.baselibrary.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 金钱格式化
 * Created by cdkj on 2017/8/12.
 */

public class MoneyUtils {

    public static final String MONEYSING = "¥";

    /**
     * 发起请求的金额计算
     *
     * @return
     */
    public static String getRequestPrice(String price) {
        return new BigDecimal(doubleFormatMoney2(new BigDecimal(price).doubleValue() * 1000)).intValue() + "";
    }

    /**
     * 发起请求的金额计算
     *
     * @return
     */
    public static String getRequestPrice(double price) {
        return new BigDecimal(doubleFormatMoney2(new BigDecimal(price).doubleValue() * 1000)).intValue() + "";
    }

    /**
     * 金钱格式化
     *
     * @param money
     * @return
     */
    public static String doubleFormatMoney(double money) {
        DecimalFormat df = new DecimalFormat("#######0.00");
        df.setRoundingMode(RoundingMode.CEILING);
        String showMoney = df.format((money));
        return showMoney/*.substring(0,showMoney.length()-1)*/;
    }

    public static Double doubleFormatMoney2(double money) {
        DecimalFormat df = new DecimalFormat("#######0.00");
        df.setRoundingMode(RoundingMode.CEILING);
        String showMoney = df.format((money));
        return new BigDecimal(showMoney).doubleValue();
    }

    public static Double doubleFormatMoney3(BigDecimal money) {
        if (money != null) {
            DecimalFormat df = new DecimalFormat("#######0.00");
            df.setRoundingMode(RoundingMode.CEILING);
            String showMoney = df.format((money));
            return new BigDecimal(showMoney).doubleValue();
        }

        return 0.00;
    }

    public static String showPrice(BigDecimal big) {

        if (big != null) {
            return doubleFormatMoney(((big.doubleValue()) / 1000));
        }
        return "0.00";
    }

    public static String showPriceDouble(double dou) {

        return  showPrice(new BigDecimal(dou));
    }

    /**
     * 显示金钱乘规格
     *
     * @param big
     * @param size
     * @return
     */
    public static String showPrice(BigDecimal big, int size) {

        if (big != null) {
            BigDecimal bigDecimal = new BigDecimal(size);

            return doubleFormatMoney((big.multiply(bigDecimal).doubleValue() / 1000));
        }

        return "0.00";

    }


    public static String getShowPriceSign(BigDecimal bigDecimal) {
        return MONEYSING + showPrice(bigDecimal);
    }

    public static String getShowPriceSign(BigDecimal bigDecimal, int size) {
        return MONEYSING + showPrice(bigDecimal, size);
    }

    public static int getPriceIntValue(BigDecimal bigDecimal) {
        return bigDecimal.intValue() / 1000;
    }

    public static BigDecimal getPriceValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return new BigDecimal(0);
        }
        return bigDecimal.divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP);
    }


    /**
     * 以万为单位显示格式化
     *
     * @param num
     * @return
     */
    public static String formatNum(BigDecimal num) {

        if (num == null || num.compareTo(BigDecimal.ZERO) == 0) return "0";
        NumberFormat nf = new DecimalFormat("#.##");
        if (num.doubleValue() < 10000) {
            return nf.format(num.doubleValue());
        }
        if (num.doubleValue() >= 100000000) {
            return nf.format(num.divide(new BigDecimal(100000000), 2, RoundingMode.HALF_UP).doubleValue()) + "亿";
        }
        return nf.format(num.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP).doubleValue()) + "万";

    }

}
