package com.sz;

import com.sz.pojo.User;
import com.sz.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void m1(){
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService",UserService.class);

        User user = new User();
        user.setUsername("admin222333");
        user.setPassword("123123");

        userService.insert(user);
    }
}
