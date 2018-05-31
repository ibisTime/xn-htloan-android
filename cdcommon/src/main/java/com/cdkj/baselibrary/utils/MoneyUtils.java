package com.cdkj.baselibrary.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

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

    public static String doubleFormatSXF(double d){
        DecimalFormat df = new DecimalFormat("#######0.000");
        String showMoney = df.format(d);
        return showMoney.substring(0,showMoney.length()-1);
    }

    /**
     * sString 转变为  double  确保传入的string可以转换为double
     * 否则出错就返回0.0
     *
     * @param money
     * @return
     */
    public static Double stringToDouble(String money) {
        try {
            if (money != null) {
                DecimalFormat df = new DecimalFormat("#######0.00");
                df.setRoundingMode(RoundingMode.CEILING);
                String showMoney = df.format(Double.parseDouble(money));
                return new BigDecimal(showMoney).doubleValue();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0.0;
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

        return showPrice(new BigDecimal(dou));
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

    /**
     * bigDecimal  做乘法结果保留两位小数返回
     *
     * @param bigDecimal
     * @return
     */
    public static BigDecimal bigDecimalRide(BigDecimal bigDecimal, double dou) {
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(dou));
        BigDecimal decimal = multiply.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal;
    }

    public static String bigDecimalRide(double one, double two) {
        BigDecimal multiply = new BigDecimal(one).multiply(new BigDecimal(two));
        BigDecimal decimal = multiply.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal.stripTrailingZeros().toPlainString();
    }

    /**
     * 用于向服务器传递参数将结果乘以1000变为厘
     */
    public static String doubleX1000(double money) {
        BigDecimal multiply = new BigDecimal(money).multiply(new BigDecimal(1000));
        BigDecimal decimal = multiply.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal.stripTrailingZeros().toPlainString();
    }


    /**
     * 将金额 乘以 1000返回String
     * @param money
     * @return
     */
    public static String priceX1000(BigDecimal money) {
        BigDecimal multiply = money.multiply(new BigDecimal(1000));
        BigDecimal decimal = multiply.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal.stripTrailingZeros().toPlainString();
    }

    /**
     * 将金额 乘以 1000返回BigDecimal
     * 用于计算
     * @param money
     * @return
     */
    public static BigDecimal moneyX1000(BigDecimal money) {
        BigDecimal multiply = money.multiply(new BigDecimal(1000));
        BigDecimal decimal = multiply.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal;
    }

    /**
     * 将金额 除以 1000返回BigDecimal
     * 用于计算
     * @param money
     * @return
     */
    public static BigDecimal moneyC1000(BigDecimal money) {
        BigDecimal multiply = money.divide(new BigDecimal(1000));
        BigDecimal decimal = multiply.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal;
    }

    /**
     * 将元乘以1000返回String
     * 用于向服务器放金额时使用
     * @param money
     * @return
     */
    public static String sendPrice1000(BigDecimal money) {
        BigDecimal multiply = money.multiply(new BigDecimal(1000));
        BigDecimal decimal = multiply.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal.stripTrailingZeros().toPlainString();
    }


}
