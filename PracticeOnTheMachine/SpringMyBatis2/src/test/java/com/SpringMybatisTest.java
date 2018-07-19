package com;

import com.pojo.User;
import com.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringMybatisTest {

    /**
     * 获取全部信息
     */
    @Test
    public  void test(){
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService",UserService.class);

        List<User>list=userService.selectInfoAlls();

        for (User user:list){
            System.out.println("用户名是:"+user.getUserName()+"   密码是:"+user.getUserPassword());
        }
    }

    /**
     * 删除指定用户信息
     */
    @Test
    public  void testDelete(){
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService",UserService.class);

        int num=userService.deleteInfoIDs(15);
        System.out.println("删除用户的返回值是:"+num);
    }

    /**
     * 修改指定用户名称
     */
    @Test
    public  void testUpdate(){
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService",UserService.class);

        int num=userService.updateInfoID("管理员2号",1);
        System.out.println("修改用户的返回值是:"+num);
    }

    /**
     * 添加新用户
     */
    @Test
    public  void testInsert(){
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService",UserService.class);

        User user=new User();
        user.setId(18);
        user.setUserCode("xiaofeng");
        user.setUserName("萧峰");
        user.setUserPassword("123456");
        user.setUserRole(3);
        user.setCreatedBy(1);

        int num=userService.insertUserInfo(user);
        System.out.println("添加用户的返回值是:"+num);
    }

}
