package com.cdkj.huatuweitong.utlis;

import java.math.BigDecimal;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/16
 * Created by lenovo on 2018/5/16.
 */

public class MoneyUtils {

    /**
     * 将厘变为元 返回String
     *1000转换率
     * @param bigDecimal
     * @return
     */
    public static String BigDecimalToString(BigDecimal bigDecimal) {

        BigDecimal divide = bigDecimal.divide(new BigDecimal(1000));
        BigDecimal decimal = divide.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal.toString();
    }

    public static String BigDecimalToString2(BigDecimal bigDecimal) {

        BigDecimal decimal = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal.toString();
    }

    public static BigDecimal StringToBigDecimal(String bigDecimal) {
        BigDecimal bigDecimal1 = new BigDecimal(Double.parseDouble(bigDecimal));
        return bigDecimal1;
    }

    /**
     * bigDecimal  做乘法结果保留两位小数返回
     * @param bigDecimal
     * @return
     */
    public static BigDecimal bigDecimalRide(BigDecimal bigDecimal,double dou) {
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(dou));
        BigDecimal decimal = multiply.setScale(2, BigDecimal.ROUND_DOWN);
        return decimal;
    }

}
