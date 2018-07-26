package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    public int addUserInfo(User user);


    /**
     *分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<User> queryPagesInfo(Integer pageNo, Integer pageSize);

}
