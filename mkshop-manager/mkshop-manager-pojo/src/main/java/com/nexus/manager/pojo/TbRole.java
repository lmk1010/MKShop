package com.nexus.manager.pojo;

public class TbRole {
    private Integer id;

    private String description;

    private String name;

    public TbRole(Integer id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public TbRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}