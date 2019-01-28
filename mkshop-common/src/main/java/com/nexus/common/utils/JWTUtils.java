package com.nexus.common.utils;


import com.auth0.jwt.algorithms.Algorithm;

import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JWTUtils
 * @Description TODO token遵守JWT标准
 * @Author liumingkang
 * @Date 2019-01-25 09:17
 * @Version 1.0
 **/
public class JWTUtils {

    /**
     * 1.创建一个32-byte的密匙
     */

    private static final byte[] secret = "thisismkshopbylmksecretkey".getBytes();


    static {
        //HMAC加密
//        Algorithm algorithm = Algorithm.HMAC256(secret);
        //RSA加密
    }




}
