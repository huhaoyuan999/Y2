package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.AirQuality;
import com.pojo.District;
import com.service.AirQualityService;
import com.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.swing.StringUIClientPropertyKey;

import java.util.Date;
import java.util.List;

/**
 * 空气质量指数表控制类
 */
@Controller
@RequestMapping("/quality")
public class AirQualityController {
    //调用区域表业务逻辑接口
    @Autowired
    @Qualifier("districtService")
    private DistrictService districtService;

    //调用空气质量指数表业务逻辑接口
    @Autowired
    @Qualifier("airQualityService")
    private AirQualityService airQualityService;

    /**
     * 初始化信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/init/{pageNo}/{pageSize}")
    public String initInfo(@PathVariable("pageNo") Integer pageNo,
                           @PathVariable("pageSize") Integer pageSize,
                           Model model) {
        List<District> district = districtService.queryAllInfo();
        PageInfo<AirQuality> airQuality = airQualityService.queryAllInfo(null, null, pageNo, pageSize);
        model.addAttribute("district", district);
        model.addAttribute("page", airQuality);
        return "index";
    }

    /**
     * 按区域查询信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/districtId")
    public String queryDistrictIdInfo(@RequestParam("districtId") Integer districtId,
                                      Model model) {
        List<District> district = districtService.queryAllInfo();
        PageInfo<AirQuality> airQuality = airQualityService.queryAllInfo(null, districtId, 1, 5);
        System.out.println("结果是：" + airQuality);
        model.addAttribute("district", district);
        model.addAttribute("page", airQuality);
        return "index";
    }

    /**
     * 添加空气质量指数信息
     *
     * @param airQuality
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public String insertAirQualityInfo(@RequestBody AirQuality airQuality) {
        int num = airQualityService.insertAirQualityInfo(airQuality);
        String booleans = "false";
        if (num > 0) {
            booleans = "true";
        }
        return booleans;
    }

    /**
     * 根据id查询指定信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/airQualityId/{id}")
    public ModelAndView queryInfoID(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUpdateDelete");
        AirQuality airQuality = airQualityService.queryAirQualityID(id);
        modelAndView.addObject("airQuality", airQuality);
        return modelAndView;
    }

    /**
     * 修改空气质量指数信息
     *
     * @param airQuality
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateAirQualityInfo(@RequestBody AirQuality airQuality) {
        airQuality.setLastModifyTime(new Date());
        int num = airQualityService.updateInfo(airQuality);
        String booleans = "false";
        if (num > 0) {
            booleans = "true";
        }
        return booleans;
    }

    /**
     * 根据ID删除指定信息
     *
     * @param airQuality
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteAirQualityInfo(@RequestBody AirQuality airQuality) {
        int num = airQualityService.deleteInfo(airQuality.getId());
        String booleans = "false";
        if (num > 0) {
            booleans = "true";
        }
        return booleans;
    }
}
