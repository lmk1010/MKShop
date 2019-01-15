package com.nexus.manager.pojo;

public class TbPermission {
    private Long id;

    private String url;

    private String name;

    private String permission;

    private Boolean available;

    public TbPermission(Long id, String url, String name, String permission, Boolean available) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.permission = permission;
        this.available = available;
    }

    public TbPermission() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}