package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName RegisterMember
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-27 21:46
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterMember implements Serializable {

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String phonenumber;

    private String sex;

    private String address;

    private String description;

    private String imgurl;

    private String registerToken;
}
