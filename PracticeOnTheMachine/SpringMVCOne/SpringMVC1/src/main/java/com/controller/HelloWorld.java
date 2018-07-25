package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorld {

    @RequestMapping("/userMa")
    public String showInfo(Model model){

        User user=new User();
        user.setUserName("张胜男");
        model.addAttribute("user",user);
        return "userName2";
    }

}
