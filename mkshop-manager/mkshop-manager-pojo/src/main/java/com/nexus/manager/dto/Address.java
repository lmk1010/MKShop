package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName Address
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-23 13:43
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    private String receiveName;

    private String receiveAddress;

    private String receivePhone;

    private String receivePostCode;

}
