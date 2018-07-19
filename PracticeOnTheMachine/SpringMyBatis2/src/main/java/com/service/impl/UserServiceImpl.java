package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    //申明Dao接口字段
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    /**
     * 查询全部信息
     *
     * @return
     */
    @Override
    public List<User> selectInfoAlls() {
        return userMapper.selectInfoAll();
    }

    /**
     * 根据Id删除指定信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteInfoIDs(Integer id) {
        return userMapper.deleteInfoID(id);
    }

    /**
     * 修改指定用户名称
     *
     * @param userName
     * @param id
     * @return
     */
    @Override
    public int updateInfoID(String userName, Integer id) {
        return userMapper.updateInfoID(userName, id);
    }

    /**
     * 添加新用户
     * @param user
     * @return
     */
    @Override
    public int insertUserInfo(User user) {
        return userMapper.insertInfo(user);
    }

}
