package com.pojo;

import java.io.Serializable;

/**
 * 电子文档分类表实体类
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 3741358553926792249L;

    private Integer id;//分类编号
    private String name;//分类名称

    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
