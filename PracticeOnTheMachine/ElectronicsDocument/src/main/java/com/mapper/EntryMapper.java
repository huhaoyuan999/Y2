package com.mapper;

import com.pojo.Entry;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 电子文档条目表DAO接口
 */
@Repository("entryMapper")
public interface EntryMapper {

    /**
     * 按条件查询信息
     *(分页查询)
     * @return
     */
    public List<Entry> queryEntryInfo(@Param("categoryId") Integer categoryId,
                                      @Param("title") String title);

    /**
     * 添加信息
     * @return
     */
    public int addEntryInfo(Entry entry);

    /**
     * 根据id删除指定信息
     * @param id
     * @return
     */
    public int deleteEntryInfo(@Param("id")Integer id);

    /**
     * 根据ID查询指定信息
     * @return
     */
    public Entry queryIdInfo(@Param("id")Integer id);

    /**
     * 修改指定信息
     * @param entry
     * @return
     */
    public int updateInfo(Entry entry);
}
