package com.nexus.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phonenumber;

    private String sex;

    private String address;

    private Integer status;

    private String description;

    private Integer roleId;

    private Date createtime;

    private Date updatetime;

    public TbUser(Integer id, String username, String password, String email, String phonenumber, String sex, String address, Integer status, String description, Integer roleId, Date createtime, Date updatetime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.address = address;
        this.status = status;
        this.description = description;
        this.roleId = roleId;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public TbUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", roleId=" + roleId +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}