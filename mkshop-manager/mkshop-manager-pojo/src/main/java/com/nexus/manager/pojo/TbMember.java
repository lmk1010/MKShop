package com.nexus.manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TbMember implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String phonenumber;

    private String sex;

    private String address;

    private String description;

    private String imgurl;

    private Date createtime;

    private Date updatetime;

}