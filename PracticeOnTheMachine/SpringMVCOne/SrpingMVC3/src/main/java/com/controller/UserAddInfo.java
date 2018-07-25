package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取前台传入JSON信息
 */
@Controller
@RequestMapping("/user")
public class UserAddInfo {

    /**
     * 使用传统方式提交表单
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/add1", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> show1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String price = request.getParameter("age");
        String dateBirth = request.getParameter("dateBirth");
        //类型转换
        Double price2 = Double.valueOf(price);
        System.out.println("获取到的名称是：" + name);
        System.out.println("获取到的价格是：" + price2);
        System.out.println("获取到的时间是：" + dateBirth);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("price", price);
        map.put("dateBirth", dateBirth);
        return map;
    }

    /**
     * 基于springmvcform单个值分开提交
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add2")
    @ResponseBody
    public Map<String, Object> show2(@RequestParam("name") String name,
                                     @RequestParam("age") Integer age) {
        //类型转换
        System.out.println("获取到的姓名是：" + name);
        System.out.println("获取到的年龄是：" + age);
//        System.out.println("获取到的出生日期是：" + dateBirth);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("age", age);
//        map.put("dateBirth", dateBirth);
        return map;
    }

    /**
     * 基于springmvcform以javabean提交
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add3")
    @ResponseBody
    public Map<String, Object> show3(User user) {
        System.out.println("获取到的姓名是：" + user.getName());
        System.out.println("获取到的年龄是：" + user.getAge());
//        System.out.println("获取到的出生日期是：" + user.getDateBirth());

        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(user);
        map.put("getName", user.getName());
        map.put("getAge", user.getAge());
        return map;
    }

    /**
     * ajax下提交json数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add4")
    @ResponseBody
    public Map<String, Object> show4(@RequestBody User user) {
        System.out.println("获取到的姓名是：" + user.getName());
        System.out.println("获取到的年龄是：" + user.getAge());
        System.out.println("获取到的出生日期是：" + user.getDateBirth());
        System.out.println(user);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("getName", "添加数据成功啦");
        return map;
    }

    /**
     * ajax下提交一组json数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add5")
    @ResponseBody
    public Map<String, Object> show5(@RequestBody List<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            System.out.println("获取到的姓名是：" + user.getName());
            System.out.println("获取到的年龄是：" + user.getAge());
            System.out.println("获取到的出生日期是：" + user.getDateBirth());
            System.out.println(user);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("getName", "添加数据成功啦");
        return map;
    }

}
