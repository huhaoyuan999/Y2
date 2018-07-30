package com.mapper;

import com.pojo.AirQuality;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 空气质量指数表DAO接口
 */
@Repository("airQualityMapper")
public interface AirQualityMapper {

    /**
     * 按条件查询相关信息(分页显示)
     * @param id
     * @param districtId
     * @return
     */
    public List<AirQuality> queryAllInfo(@Param("id") Integer id, @Param("districtId") Integer districtId);

    /**
     * 添加空气质量指数信息
     * @param airQuality
     * @return
     */
    public int insertAirQualityInfo(AirQuality airQuality);

    /**
     * 根据id查询指定信息
     * @param id
     * @return
     */
    public AirQuality queryAirQualityID(@Param("id")Integer id);

    /**
     * 修改信息
     * @param airQuality
     * @return
     */
    public int updateInfo(AirQuality airQuality);

    /**
     * 根据id删除指定信息
     * @param id
     * @return
     */
    public int deleteInfo(@Param("id")Integer id);
}
