package com.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class TestInfo1 {

    @RequestMapping("/info")
    public String show1(Model model){
        model.addAttribute("info","发呆刷卡机");
        return "userInfo1";
    }

    @RequestMapping(value = "/info2",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String show2(){
        String name="风景搜附近记录肯定是房价的顺口溜";
        return name;
    }

}
