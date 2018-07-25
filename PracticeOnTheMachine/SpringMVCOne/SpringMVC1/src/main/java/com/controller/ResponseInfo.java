package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/response")
public class ResponseInfo {

    //转发操作
    @RequestMapping("/user")
    public ModelAndView show1(@RequestParam(value = "name", required = false) String name) {
        User user = new User();
        user.setUserName("李师傅");
        user.setUserPassword("123456");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userName2");
        modelAndView.addObject("user", user);
        modelAndView.addObject("userName", name);
        return modelAndView;
    }

    //重定向到一个指定的新地址
    @RequestMapping("/sendRedirect")
    public String show2(){
        System.out.println("重定向到一个新地址");
        return "redirect:/jsp/userName.jsp";
    }

}
