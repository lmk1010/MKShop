package com.nexus.common.model;

/**
 * @ClassName ResponseCode
 * @Description TODO 定义常用响应状态码
 * @Author liumingkang
 * @Date 2019-01-12 19:11
 * @Version 1.0
 **/
public enum ResponseCode {


    SUCCESS(200,"成功"),
    NEED_LOGIN(301,"需要登陆"),
    ILLEGA_ARGUMENT(302,"错误的参数"),
    ERROR(500,"失败"),
    NO_USER(403,"没有此用户"),
    EXIST_USER(402,"已存在的用户");

    private final int code;
    private final String status;

    ResponseCode(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

}
