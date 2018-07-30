package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 空气质量指数表实体类
 */
public class AirQuality {
    private Integer id;//记录编号
    private Integer districtId;//区域编号
    private Date monitorTime;//监测时间
    private Integer pm10;//pm10值
    private Integer pm25;//pm2.5值
    private String monitoringStation;//监测站

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date lastModifyTime;//创建时间

    public AirQuality() {
    }

    public AirQuality(Integer id, Integer districtId, Date monitorTime, Integer pm10, Integer pm25, String monitoringStation, Date lastModifyTime) {
        this.id = id;
        this.districtId = districtId;
        this.monitorTime = monitorTime;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.monitoringStation = monitoringStation;
        this.lastModifyTime = lastModifyTime;
    }

    public AirQuality(Integer districtId, Date monitorTime, Integer pm10, Integer pm25, String monitoringStation) {
        this.districtId = districtId;
        this.monitorTime = monitorTime;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.monitoringStation = monitoringStation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public Integer getPm25() {
        return pm25;
    }

    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    public String getMonitoringStation() {
        return monitoringStation;
    }

    public void setMonitoringStation(String monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

}
