package com.nexus.common.model;

/**
 * @ClassName Constant
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-14 16:37
 * @Version 1.0
 **/
public class Constant {

    public static String CURRENT_USER = "user";

    public static Integer TOKEN_EXPIRE = 1800;

    public static Integer SESSION_EXPIRE = 18000;

    public static String TOKEN_PREFIX = "Token_";

    public static String CODE_TAG = "Verify_token";

    public static String SORTED_DESC =  "desc";

    public static String SORTED_ASC =  "asc";

    public static String ROLES_KEY = "role_cache_yes";

    public static String PERMISSION_KEY = "permission_cache_key";

    public enum SendSMSMode{

        FORGET_MODE(101,"忘记"),
        REGISTER_MODE(102,"注册");

        private String value;
        private int code;

        SendSMSMode(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public enum CartStatusCode{
        REV_SUCCESS(20000,"获取购物车信息成功"),
        ADD_SUCCESS(20010,"已成功添加商品"),
        ADD_FAILED(20011,"添加商品失败"),
        DEL_SUCCESS(30010,"移除商品成功"),
        DEL_FAILED(30011,"删除商品失败");

        private String value;
        private int code;

        CartStatusCode(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public enum CategoryStatusCode{
        ACTIVED("已开启",2000),
        DISABLED("已停用",2001);

        private String value;
        private int code;

        CategoryStatusCode(String value,int code){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }



    public enum OrderStatusCode{
        CANCEL(0,"已取消"),
        NO_PAY(10,"未支付"),
        PAID(20,"已支付"),
        SHIPPED(30,"已发货"),
        ORDER_SUCCESS(40,"订单完成"),
        ORDER_CLOSE(50,"订单关闭");

        private String value;
        private int code;

        OrderStatusCode(int code,String value){
            this.code = code;
            this.value = value;
        }

        public static OrderStatusCode codeOf(int code){
            for (OrderStatusCode payTypeEnum : values()){
                if (payTypeEnum.getCode() == code){
                    return payTypeEnum;
                }
            }
            throw new RuntimeException("没有找到枚举类型");
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public enum PayPlatFormEnum{

        ALIPAY(1,"支付宝"),
        WECHAT(2,"微信支付");

        private String value;
        private int code;

        PayPlatFormEnum(int code,String value){
            this.code = code;
            this.value = value;

        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public enum PayTypeEnum {
        ON_LINE_PAY(1, "在线支付");

        private String value;
        private int code;

        PayTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;

        }

        public static PayTypeEnum codeOf(int code) {
            for (PayTypeEnum payTypeEnum : values()) {
                if (payTypeEnum.getCode() == code) {
                    return payTypeEnum;
                }
            }
            throw new RuntimeException("没有找到枚举类型");
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

}
