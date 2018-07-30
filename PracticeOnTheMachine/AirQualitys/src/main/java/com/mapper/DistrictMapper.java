package com.mapper;

import com.pojo.District;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 区域表DAO接口
 */
@Repository("districtMapper")
public interface DistrictMapper {

    /**
     * 查询详细信息
     * @return
     */
    public List<District> queryAllInfo();

}
