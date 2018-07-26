package com.mapper;

import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    public int addUserInfo(User user);

    /**
     * 分页查询
     * @return
     */
    public List<User> queryPageInfo();

}
