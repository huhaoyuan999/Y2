package com.service.impl;

import com.mapper.CategoryMapper;
import com.pojo.Category;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 电子文档分类表业务逻辑接口实现类
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    //声明DAO接口
    @Autowired
    @Qualifier("categoryMapper")
    private CategoryMapper categoryMapper;

    /**
     * 查询分类表全部信息
     * @return
     */
    @Override
    public List<Category> queryAllInfo() {
        //调用DAO层方法
        return categoryMapper.queryAllInfo();
    }
}
