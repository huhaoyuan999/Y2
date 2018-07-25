package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/param")
public class RequestParams {

    @RequestMapping("/user")
    public ModelAndView showInfo(@RequestParam(value = "id", required = false) Integer id) {
        System.out.println("请求参数:" + id);
        System.out.println("进来啦！参数在上面");

        ModelAndView andView = new ModelAndView();
        andView.setViewName("showName");
        andView.addObject("id", id);
        return andView;
    }

    @RequestMapping("/user2")
    public ModelAndView showInfos(@RequestParam(value = "id", required = false) Integer id,
                                  @RequestParam(value = "name", required = false) String name) {
        System.out.println("请求参数id是:" + id);
        System.out.println("请求参数name是:" + name);
        System.out.println("进来啦！参数在上面");

        ModelAndView andView = new ModelAndView();
        andView.setViewName("showName");
        andView.addObject("id", id);
        andView.addObject("name", name);
        return andView;
    }

}
