package com.service;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    /**
     * 查询全部信息
     * @return
     */
    public List<User> selectInfoAlls();

    /**
     * 根据Id删除指定信息
     * @return
     */
    public int deleteInfoIDs(@Param("id")Integer id);

    /**
     * 修改指定用户名称
     * @param userName
     * @param id
     * @return
     */
    public int updateInfoID(String userName,Integer id);

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUserInfo(User user);

}
