package com.sz.service.impl;

import com.sz.mapper.CategoryMapper;
import com.sz.pojo.Category;
import com.sz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listAll() {
        return categoryMapper.listAll();
    }


}
