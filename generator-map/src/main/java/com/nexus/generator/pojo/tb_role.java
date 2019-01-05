package com.nexus.generator.pojo;

public class tb_role {
    private Integer id;

    private String description;

    private String name;

    public tb_role(Integer id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public tb_role() {
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