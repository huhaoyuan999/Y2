package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查询记录数
     * @return
     */
    public int counts();

    /**
     * 查询全部信息
     * @return
     */
    public List<User> getUserList();


}
