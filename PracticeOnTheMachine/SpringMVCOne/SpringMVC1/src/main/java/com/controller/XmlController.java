package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class XmlController {

    @RequestMapping("/userName2")
    public String showInfo(@RequestParam("name")String name){
        System.out.println("进入到方法里面啦！");
        System.out.println("参数的值是："+name);
        return "userName";
    }

}
