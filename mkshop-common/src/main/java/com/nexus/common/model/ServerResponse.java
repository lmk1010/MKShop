package com.nexus.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ServerResponse
 * @Description  data is 服务器返回数据
 * ***********   statuscode is 返回状态码
 * ***********   responsetime is 返回当前时间戳
 * @Author liumingkang
 * @Date 2019-01-12 19:00
 * @Version 1.0
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable{

    private T data;
    private int statuscode;
    private String msg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date responsetime;

    public ServerResponse(T data, int statuscode, Date responsetime) {
        this.data = data;
        this.statuscode = statuscode;
        this.responsetime = responsetime;
    }
    public ServerResponse(int statuscode, Date responsetime) {
        this.statuscode = statuscode;
        this.responsetime = responsetime;
    }

    public ServerResponse(int statuscode, String msg, Date responsetime) {
        this.statuscode = statuscode;
        this.msg = msg;
        this.responsetime = responsetime;
    }

    public boolean isSuccess(){
        if (this.getStatuscode()==200){
            return true;
        }else{
            return false;
        }
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),new Date());
    }

    public static <T> ServerResponse<T> createBySuccessMsg(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,new Date());
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(data,ResponseCode.SUCCESS.getCode(),new Date());
    }

    public static <T> ServerResponse<T> createBySuccess(T data,String msg){
        return new ServerResponse<T>(data,ResponseCode.SUCCESS.getCode(),msg,new Date());
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),new Date());
    }

    public static <T> ServerResponse<T> createByErrorMsg(String msg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg,new Date());
    }

    public static <T> ServerResponse<T> createByErrorCode(String msg,Integer Code){
        return new ServerResponse<T>(Code,msg,new Date());
    }



}
