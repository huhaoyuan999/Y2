package com.pojo;

import java.text.Format;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 电子文档条目表实体类
 */
public class Entry implements Serializable {
    private static final long serialVersionUID = 3741358553926792249L;

    private Integer id;//编号
    private Integer categoryId;//分类编号
    private String title;//文档名称
    private String summary;//摘要
    private String uploaduser;//上传人

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdate;//创建时间

    public Entry() {
    }

    public Entry(Integer id, Integer categoryId, String title, String summary, String uploaduser, Date createdate) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.summary = summary;
        this.uploaduser = uploaduser;
        this.createdate = createdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
