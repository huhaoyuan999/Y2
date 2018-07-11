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
    public int deleteID(@Param("id") Integer id);

    /**
     * 修改用户名
     * @param id
     * @param userName
     * @return
     */
    public  int updateSetInfo(@Param("id") Integer id, @Param("userName") String userName);

    /**
     * 查询全部信息
     * @return
     */
    public List<User> selectAllInfo();

    /**
     *
     * @return
     */
    public List<User>listRootInfo();

    /**
     * 查询全部信息
     * @return
     */
    public List<User>listAllInfos();

    /**
     * 查询指定用户列表
     * @param userName
     * @param userRole
     * @return
     */
    public List<User> getUserList(@Param("userName")String userName,@Param("userRole")Integer userRole);

    /**
     * 修改信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 修改用户名
     * @return
     */
    public int updateUserName(User user);

}
