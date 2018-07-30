package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.AirQualityMapper;
import com.pojo.AirQuality;
import com.service.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 空气质量指数表业务逻辑接口实现类
 */
@Service("airQualityService")
public class AirQualityServiceImpl implements AirQualityService {
    //定义DAO接口
    @Autowired
    @Qualifier("airQualityMapper")
    private AirQualityMapper airQualityMapper;

    /**
     * 按条件查询相关信息(分页显示)
     *
     * @param id
     * @param districtId
     * @return
     */
    @Override
    public PageInfo<AirQuality> queryAllInfo(Integer id, Integer districtId, Integer pageNo, Integer pageSize) {
        //调用页面助手
        PageHelper.startPage(pageNo, pageSize);
        //调用DAO层方法
        List<AirQuality> list = airQualityMapper.queryAllInfo(id, districtId);
        // 调用这个构造器，我们的分页助手对象就构建成功
        PageInfo<AirQuality> pageInfo = new PageInfo<AirQuality>(list);
        return pageInfo;
    }

    /**
     * 添加空气质量指数信息
     *
     * @param airQuality
     * @return
     */
    @Override
    public int insertAirQualityInfo(AirQuality airQuality) {
        //调用DAO层方法
        return airQualityMapper.insertAirQualityInfo(airQuality);
    }

    /**
     * 根据id查询指定信息
     *
     * @param id
     * @return
     */
    @Override
    public AirQuality queryAirQualityID(Integer id) {
        //调用DAO层方法
        return airQualityMapper.queryAirQualityID(id);
    }

    /**
     * 修改信息
     *
     * @param airQuality
     * @return
     */
    @Override
    public int updateInfo(AirQuality airQuality) {
        //调用DAO层方法
        return airQualityMapper.updateInfo(airQuality);
    }

    /**
     * 根据id删除指定信息
     * @param id
     * @return
     */
    @Override
    public int deleteInfo(Integer id) {
        //调用DAO层方法
        return airQualityMapper.deleteInfo(id);
    }


}
