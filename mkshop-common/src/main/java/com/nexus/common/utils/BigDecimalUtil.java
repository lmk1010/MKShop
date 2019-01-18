package com.nexus.common.utils;

import java.math.BigDecimal;

/**
 * Created by liumingkang on 2018/9/10.
 * @description bigdecimal的加减乘除的工具类
 */
public class BigDecimalUtil {

    public BigDecimalUtil() {
    }

    public static BigDecimal add(double a, double b){
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.add(b1);
    }
    public static BigDecimal mul(double a, double b){
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.multiply(b1);
    }
    public static BigDecimal div(double a, double b){
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.divide(b1,2,BigDecimal.ROUND_HALF_UP);
    }
    public static BigDecimal sub(double a, double b){
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.subtract(b1);
    }

}
