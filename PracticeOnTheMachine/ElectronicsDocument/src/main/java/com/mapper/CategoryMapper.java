package com.mapper;

import com.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 电子文档分类表DAO接口
 */
@Repository("categoryMapper")
public interface CategoryMapper {

    /**
     * 查询分类表全部信息
     * @return
     */
    public List<Category> queryAllInfo();

}
