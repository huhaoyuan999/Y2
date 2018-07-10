package com.mybatis.dao;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

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
//    public List<User> getUserList();

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    public int deleteID(@Param("id")Integer id);

    /**
     * 修改用户名
     * @param id
     * @param userName
     * @return
     */
    public  int updateSetInfo(@Param("id")Integer id,@Param("userName")String userName);

    /**
     * 查询全部信息
     * @return
     */
    public List<User> selectAllInfo();

}
