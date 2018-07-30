package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Entry;

import java.util.List;

/**
 * 电子文档条目表业务逻辑接口
 */
public interface EntryService {

    /**
     * 按条件查询信息
     * (分页查询)
     *
     * @return
     */
    public PageInfo<Entry> queryEntryInfo(Integer categoryId, String title, Integer pageNo, Integer pageSize);

    /**
     * 添加信息
     *
     * @return
     */
    public int addEntryInfo(Entry entry);

    /**
     * 根据id删除指定信息
     *
     * @param id
     * @return
     */
    public int deleteEntryInfo(Integer id);

    /**
     * 根据ID查询指定信息
     *
     * @return
     */
    public Entry queryIdInfo(Integer id);

    /**
     * 修改指定信息
     * @param entry
     * @return
     */
    public int updateInfo(Entry entry);

}
