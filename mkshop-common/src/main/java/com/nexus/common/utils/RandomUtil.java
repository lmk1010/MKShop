package com.nexus.common.utils;

import java.util.Random;

/**
 * @ClassName RandomUtil
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-14 20:08
 * @Version 1.0
 **/
public class RandomUtil {


    public static String getRandom(){
        Random random = new Random();
        int x = random.nextInt(899999);
        x = x+100000;
        return String.valueOf(x);
    }

    public static void main(String[] args){
        for (int i =1 ;i<100;i++){
            System.err.println(getRandom());
        }
    }

}
