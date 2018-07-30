package com.sz.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分类信息实体类
 */
public class Category  implements Serializable {

    private static final long serialVersionUID = 1332431192436602951L;



    private Long id;

    private String name;

    private List<Entry> entries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
