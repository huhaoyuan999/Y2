package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.AirQuality;


/**
 * 空气质量指数表业务逻辑接口
 */
public interface AirQualityService {

    /**
     * 按条件查询相关信息(分页显示)
     *
     * @param id
     * @param districtId
     * @return
     */
    public PageInfo<AirQuality> queryAllInfo(Integer id, Integer districtId, Integer pageNo, Integer pageSize);

    /**
     * 添加空气质量指数信息
     *
     * @param airQuality
     * @return
     */
    public int insertAirQualityInfo(AirQuality airQuality);

    /**
     * 根据id查询指定信息
     *
     * @param id
     * @return
     */
    public AirQuality queryAirQualityID(Integer id);

    /**
     * 修改信息
     *
     * @param airQuality
     * @return
     */
    public int updateInfo(AirQuality airQuality);

    /**
     * 根据id删除指定信息
     *
     * @param id
     * @return
     */
    public int deleteInfo(Integer id);

}
