package com.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/path")
public class MyPath {

    //请求路径表达式(编码格式设置为UTF-8)
    @RequestMapping(value="/urse/{id}/delete",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String showPath(@PathVariable("id") String id) {
        System.out.println("已经成功删除了ID为:" + id + "的用户啦！");
        return "已经成功删除了ID为:" + id + "的用户啦！";
    }
}
