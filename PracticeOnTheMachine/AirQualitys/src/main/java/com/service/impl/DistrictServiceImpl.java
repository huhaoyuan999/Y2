package com.service.impl;

import com.mapper.DistrictMapper;
import com.pojo.District;
import com.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 区域表业务逻辑接口实现类
 */
@Service("districtService")
public class DistrictServiceImpl implements DistrictService {
    //定义DAO接口
    @Autowired
    @Qualifier("districtMapper")
    private DistrictMapper districtMapper;

    /**
     * 查询详细信息
     *
     * @return
     */
    @Override
    public List<District> queryAllInfo() {
        //调用DAO层方法
        return districtMapper.queryAllInfo();
    }
}
