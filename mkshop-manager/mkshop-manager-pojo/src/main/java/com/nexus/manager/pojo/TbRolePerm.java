package com.nexus.manager.pojo;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

public class TbRolePerm implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer permId;

    public TbRolePerm(Integer id, Integer roleId, Integer permId) {
        this.id = id;
        this.roleId = roleId;
        this.permId = permId;
    }

    public TbRolePerm() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }
}