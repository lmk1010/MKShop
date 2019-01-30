package com.nexus.manager.pojo;

public class TbUserRole {
    private Long id;

    private Long userId;

    private Long roleId;

    public TbUserRole(Long id, Long userId, Long roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }

    public TbUserRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}