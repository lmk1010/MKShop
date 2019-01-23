package com.nexus.common.utils;

import xyz.downgoon.snowflake.Snowflake;

/**
 * @ClassName NumberUtil
 * @Description TODO 用于生成订单号 全数字 采用雪花算法
 * @Author liumingkang
 * @Date 2019-01-23 09:12
 * @Version 1.0
 **/
public class NumberUtil {

    //机器识别码
    private static int MACHINE_CODE = 3;
    //业务码 自由组合
    private static int WORKED_CODE = 5;

    private static Snowflake snowflake;

    static {
        //静态初始化 保证只使用一个snowflake 才能保证ID唯一
        snowflake = new Snowflake(MACHINE_CODE, WORKED_CODE);
    }

    public NumberUtil() {

    }

    public NumberUtil(int MACHINE_CODE, int WORKED_CODE) {
        this.MACHINE_CODE = MACHINE_CODE;
        this.WORKED_CODE = WORKED_CODE;
    }

    public static long getNumber(){
        return snowflake.nextId();
    }

    public int getMACHINE_CODE() {
        return MACHINE_CODE;
    }

    public void setMACHINE_CODE(int MACHINE_CODE) {
        this.MACHINE_CODE = MACHINE_CODE;
    }

    public int getWORKED_CODE() {
        return WORKED_CODE;
    }

    public void setWORKED_CODE(int WORKED_CODE) {
        this.WORKED_CODE = WORKED_CODE;
    }


}
