package com.service;

import com.pojo.Category;

import java.util.List;

/**
 * 电子文档分类表业务逻辑接口
 */
public interface CategoryService {

    /**
     * 查询分类表全部信息
     * @return
     */
    public List<Category> queryAllInfo();

}
