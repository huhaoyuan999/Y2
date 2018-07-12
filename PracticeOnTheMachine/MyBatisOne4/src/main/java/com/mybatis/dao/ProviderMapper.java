package com.mybatis.dao;

import com.mybatis.pojo.Provider;

import java.util.List;

/**
 * 供应商表Dao接口
 */
public interface ProviderMapper {

    /**
     * 回取全部信息
     * @return
     */
    public List<Provider>allProviderInfo();

}
