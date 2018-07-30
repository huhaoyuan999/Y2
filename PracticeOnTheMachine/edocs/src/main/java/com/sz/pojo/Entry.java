package com.sz.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * entry实实体类
 */
public class Entry  implements Serializable {


    private static final long serialVersionUID = 3741358553926792249L;
    private Long  id;



    private String title;

    private String summary;

    private String uploadUser;

    private Date createDate;

    /**
     * 一个entry在某个分类之下
     */
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
