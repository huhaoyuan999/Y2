package com.controller;

import com.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.naming.Name;

@Controller
@RequestMapping("/test")
public class TestGetPost {

    //测试Get方法
    @GetMapping(value = "/show1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String show1(@RequestParam(value = "name", required = false) String name) {
        System.out.println("请求的用户名是：" + name);
        return "userName";
    }

    //请求路径表达式(编码格式设置为UTF-8)
    @RequestMapping(value = "/user/{id}/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ModelAndView showPath(@PathVariable("id") String id) {
        System.out.println("已经成功修改了ID为:" + id + "的用户啦！");
        String userName = "已经成功修改了ID为:" + id + "的用户啦！";
        ModelAndView mview = new ModelAndView();
        mview.addObject("userName", userName);
        mview.setViewName("userName2");
        return mview;
    }

    @PostMapping(value = "/show3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String show3() {
        return "开发商的解放路考试结束数据";
    }

    @RequestMapping(value = "/show5", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String show5() {
        return "健康速度快放假时减肥圣诞节快乐的是否";
//        String name="健康速度快放假时减肥圣诞节快乐的是否";
    }


    @RequestMapping(value = "/userName2", method = RequestMethod.GET)
    @ResponseBody
    public User show6(@RequestParam(value = "name", required = false) String name) {
        System.out.println("传入的参数是：" + name);
        User user = new User();
        user.setUserName("李师傅");
        user.setUserPassword("123456");
        return user;
    }
}
