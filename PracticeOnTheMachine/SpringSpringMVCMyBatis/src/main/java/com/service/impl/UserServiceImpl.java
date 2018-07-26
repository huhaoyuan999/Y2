package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    //定义数据库接口
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int addUserInfo(User user) {
        //调用UserMapper接口方法
        return userMapper.addUserInfo(user);
    }

    /**
     * 分页查询
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<User> queryPagesInfo(Integer pageNo, Integer pageSize) {
        //调用页面助手
        PageHelper.startPage(pageNo, pageSize);
        //调用DAO层方法
        List<User> list = userMapper.queryPageInfo();
        // 调用这个构造器，我们的分页助手对象就构建成功
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo;
    }
}
