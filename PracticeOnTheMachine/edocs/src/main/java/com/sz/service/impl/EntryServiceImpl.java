package com.sz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sz.mapper.EntryMapper;
import com.sz.pojo.Category;
import com.sz.pojo.Entry;
import com.sz.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Service("entryService")
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryMapper entryMapper;


    @Override
    public PageInfo<Entry> listAll() {
        PageHelper.startPage(1,2);

        List<Entry>  l = entryMapper.listAll();
        PageInfo<Entry> pageInfo = new PageInfo<>(l);
        return pageInfo;
    }

    @Override
    public PageInfo<Entry> listWithPage(Integer pageNum,Long categoryId) {

        PageHelper.startPage(pageNum,2);

        List<Entry>  l = entryMapper.list(categoryId);
        PageInfo<Entry> pageInfo = new PageInfo<>(l);
        return pageInfo;
    }

    @Override
    public int delete(Integer id) {
        return entryMapper.delete(id);
    }
}
