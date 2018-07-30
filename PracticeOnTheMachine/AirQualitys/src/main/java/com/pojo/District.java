package com.pojo;

/**
 * 区域表实体类
 */
public class District {
    private Integer id;//区域编号
    private String name;//区域名称

    public District() {
    }

    public District(Integer id, String name) {
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
