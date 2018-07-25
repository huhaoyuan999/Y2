package com.controller;

import com.pojo.Dog;
import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试各种JSON数据
 */
@Controller
@RequestMapping("/user2")
public class TestJsonInfo {

    //测试javaBean传递
    @RequestMapping("/show1")
    public String show1(Model model) {
        User user = new User("张三", 23);
        Dog dog = new Dog("果果", 3);
        model.addAttribute("user", user);
        model.addAttribute("dog", dog);
        return "userInfo2";
    }

    //测试List集合传递
    @RequestMapping("/list")
    @ResponseBody
    public List<User> Show2() {
        User user1 = new User("张三", 23);
        User user2 = new User("李四", 24);
        User user3 = new User("王五", 25);
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }

    //测试javaBean传递
    @PostMapping("/show3")
    @ResponseBody
    public User show3(Model model) {
        User user = new User("萧峰", 33);
        return user;
    }


    //测试数组传递
    @PostMapping("/show4")
    @ResponseBody
    public User[] show4() {
        User user1 = new User("萧峰", 33);
        User user2 = new User("段誉", 23);
        User user3 = new User("虚竹", 25);
        User[] user = new User[]{user1, user2, user3};
        return user;
    }

    //测试简单Map集合传递
    @PostMapping("/show5")
    @ResponseBody
    public Map<String, User> show5() {
        User user1 = new User("萧峰2", 33);
        User user2 = new User("段誉2", 23);
        User user3 = new User("虚竹2", 25);
        Map<String, User> map = new HashMap<String, User>();
        map.put("user1", user1);
        map.put("user2", user2);
        map.put("user3", user3);
        return map;
    }

    //测试复杂Map集合传递
    @PostMapping("/show6")
    @ResponseBody
    public List<Map<String, Object>> show6() {
        User user1 = new User("萧峰2", 33);
        User user2 = new User("段誉2", 23);
        User user3 = new User("虚竹2", 25);
        Dog dog1 = new Dog("西西", 2);
        Dog dog2 = new Dog("果果", 3);
        Dog dog3 = new Dog("倩倩", 5);
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("user", user1);
        map1.put("dog", dog1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map1.put("user", user2);
        map1.put("dog", dog2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map1.put("user", user3);
        map1.put("dog", dog3);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        return list;
    }

}
