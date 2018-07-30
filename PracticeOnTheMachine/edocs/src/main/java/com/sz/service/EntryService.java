package com.sz.service;

import com.github.pagehelper.PageInfo;
import com.sz.pojo.Category;
import com.sz.pojo.Entry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

public interface EntryService {
    PageInfo<Entry> listAll();

    PageInfo<Entry> listWithPage(Integer pageNum,Long categoryId);

    int delete(Integer id);
}
