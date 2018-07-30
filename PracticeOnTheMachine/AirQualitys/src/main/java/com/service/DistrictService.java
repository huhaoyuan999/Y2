package com.service;

import com.pojo.District;

import java.util.List;

/**
 * 区域表业务逻辑接口
 */
public interface DistrictService {

    /**
     * 查询详细信息
     * @return
     */
    public List<District> queryAllInfo();

}
