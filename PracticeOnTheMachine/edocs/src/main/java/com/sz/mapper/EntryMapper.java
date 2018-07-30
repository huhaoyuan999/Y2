package com.sz.mapper;

import com.sz.pojo.Category;
import com.sz.pojo.Entry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * entryMapper
 */
public interface EntryMapper {
    List<Entry> listAll();

    List<Entry> list(@Param("categoryId") Long categoryId);

    int delete(@Param("id") Integer id);
}
