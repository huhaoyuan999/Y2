package com.mybatis.dao;

import com.mybatis.pojo.Address;
import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户表Dao接口
 */
public interface UserMapper {

    /**
     * 查询记录数
     *
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
     *
     * @param id
     * @return
     */
    public int deleteID(@Param("id") Integer id);

    /**
     * 修改用户名
     *
     * @param id
     * @param userName
     * @return
     */
    public int updateSetInfo(@Param("id") Integer id, @Param("userName") String userName);

    /**
     * 查询全部信息
     *
     * @return
     */
    public List<User> selectAllInfo();

    /**
     * @return
     */
    public List<User> listRootInfo();

    /**
     * 查询全部信息
     *
     * @return
     */
    public List<User> listAllInfos();

    /**
     * 查询指定用户列表
     *
     * @param userName
     * @param userRole
     * @return
     */
    public List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer userRole);

    /**
     * 修改信息
     *
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 修改用户名
     *
     * @return
     */
    public int updateUserName(User user);

    /**
     * 根据角色列表，获取角色列表下的信息
     *
     * @return
     */
    public List<User> getClomnInfo(Integer[] roles);

    /**
     * 根据角色列表，获取角色列表下的信息
     *
     * @return
     */
    public List<User> getListInfo(List<Integer> roles);

    /**
     * 根据用户角色跟用户性别获取用户信息
     *
     * @return
     */
    public List<User> getListUserInfo(Map<String, Object> collections);

    /**
     * 根据角色列表，获取角色列表下的信息
     *
     * @return
     */
    public List<User> getListInfoMap(Map<String, Object> roles);


    public List<User> getListInfoChoose(@Param("id") Integer id,
                                        @Param("userCode") String userCode,
                                        @Param("userName") String userName,
                                        @Param("userPassword") String userPassword);

    /**
     * 分页显示用户信息
     *
     * @return
     */
    public List<User> getListInfoListLimit(@Param("current") Integer currentPageNo,
                                           @Param("pageSize") Integer pageSize);

    /**
     * 根据角色信息获取角色名称
     * @return
     */
    public List<User>getListRoleId(@Param("userRole")Integer userRole);

    /**
     * 根据用户id获取用户列表信息
     * @return
     */
    public List<User>getAddressByUserId(@Param("id")Integer userId);

    /**
     * 模糊查询角色信息
     * @return
     */
    public List<User>listConcatInfo(@Param("userName")String userName,@Param("userRole")Integer userRole);

    /**
     * 根据用户id获取用户地址信息
     * @param id
     * @return
     */
    public List<User>getIdUserAdderssInfo(@Param("id")Integer id);

}
