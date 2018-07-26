package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    //定义业务逻辑接口
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 增加用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public String addUserInfo(User user) {
        int row = userService.addUserInfo(user);
        //判断返回结果，从定向到相应的页面
        return row == 1 ? "redirect:/user/page/1/5" : "redirect:/jsp/failure.jsp";
    }

    /**
     * 分页查询信息
     *
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("/page/{pageNo}/{pageSize}")
    public String queryWithPage(@PathVariable("pageNo") Integer pageNo,
                                @PathVariable("pageSize") Integer pageSize,
                                Model model) {
        PageInfo<User> pageInfo = userService.queryPagesInfo(pageNo, pageSize);
        model.addAttribute("page", pageInfo);
        return "index";
    }
}
