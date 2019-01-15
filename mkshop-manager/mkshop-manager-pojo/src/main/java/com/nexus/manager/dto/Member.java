package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName Member
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-15 14:17
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member implements Serializable {

    private long id;

    private String username;

    private String nickname;

    private String email;

    private String phonenumber;

    private String sex;

    private String address;

    private String description;

    private String imgurl;

    private String token;



}
