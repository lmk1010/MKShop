package com.nexus.manager.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName AddressVo
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-12 14:10
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressVo {

    //收货人
    private String receiveName;
    //收货人所在地区
    private String receiveLocation;
    //收货详细地址
    private String receiveAddress;
    //收货手机号
    private String receivePhone;
    //收货邮政编码
    private String receivePostCode;



}
