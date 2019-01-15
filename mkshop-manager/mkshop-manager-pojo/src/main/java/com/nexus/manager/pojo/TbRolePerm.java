package com.nexus.manager.pojo;

public class TbRolePerm {
    private Long id;

    private Long roleId;

    private Long permId;

    public TbRolePerm(Long id, Long roleId, Long permId) {
        this.id = id;
        this.roleId = roleId;
        this.permId = permId;
    }

    public TbRolePerm() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }
}