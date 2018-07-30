package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EntryMapper;
import com.pojo.Entry;
import com.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 电子文档条目表业务逻辑接口实现类
 */
@Service("entryService")
public class EntryServiceImpl implements EntryService {
    //申明DAO接口
    @Autowired
    @Qualifier("entryMapper")
    private EntryMapper entryMapper;

    /**
     * 按条件查询信息
     *
     * @param categoryId
     * @param title
     * @return
     */
    @Override
    public PageInfo<Entry> queryEntryInfo(Integer categoryId, String title, Integer pageNo, Integer pageSize) {
        //调用页面助手
        PageHelper.startPage(pageNo, pageSize);
        //调用DAO层方法
        List<Entry> list = entryMapper.queryEntryInfo(categoryId, title);
        // 调用这个构造器，我们的分页助手对象就构建成功
        PageInfo<Entry> pageInfo = new PageInfo<Entry>(list);
        return pageInfo;
    }

    /**
     * 添加信息
     *
     * @param entry
     * @return
     */
    @Override
    public int addEntryInfo(Entry entry) {
        return entryMapper.addEntryInfo(entry);
    }

    /**
     * 根据id删除指定信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteEntryInfo(Integer id) {
        return entryMapper.deleteEntryInfo(id);
    }

    /**
     * 根据ID查询指定信息
     *
     * @param id
     * @return
     */
    @Override
    public Entry queryIdInfo(Integer id) {
        return entryMapper.queryIdInfo(id);
    }

    /**
     * 修改指定信息
     * @param entry
     * @return
     */
    @Override
    public int updateInfo(Entry entry) {
        return entryMapper.updateInfo(entry);
    }
}
