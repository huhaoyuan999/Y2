package cn.smbms.dao.user;

import java.sql.Connection;
import java.util.List;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 增加用户信息
     *
     * @param connection
     * @param user
     * @return
     * @throws Exception
     */
    public int add(Connection connection, User user) throws Exception;

    /**
     * 通过userCode获取User
     *
     * @param connection
     * @param userCode
     * @return
     * @throws Exception
     */
    public User getLoginUser(Connection connection, String userCode) throws Exception;

    /**
     * 通过条件查询-userList
     *
     * @param connection
     * @param userName
     * @param userRole
     * @return
     * @throws Exception
     */
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

    /**
     * 通过条件查询-用户表记录数
     *
     * @param connection
     * @param userName
     * @param userRole
     * @return
     * @throws Exception
     */
    public int getUserCount(Connection connection, String userName, int userRole) throws Exception;

    /**
     * 通过userId删除user
     *
     * @param delId
     * @return
     * @throws Exception
     */
    public int deleteUserById(Connection connection, Integer delId) throws Exception;


    /**
     * 通过userId获取user
     *
     * @param connection
     * @param id
     * @return
     * @throws Exception
     */
    public User getUserById(Connection connection, String id) throws Exception;

    /**
     * 修改用户信息
     *
     * @param connection
     * @param user
     * @return
     * @throws Exception
     */
    public int modify(Connection connection, User user) throws Exception;


    /**
     * 修改当前用户密码
     *
     * @param connection
     * @param id
     * @param pwd
     * @return
     * @throws Exception
     */
    public int updatePwd(Connection connection, int id, String pwd) throws Exception;


    /**
     * 用户登录(改过)
     *
     * @param userCode
     * @param userPassword
     * @return
     */
    public User loginUser(@Param("userCode") String userCode, @Param("userPassword") String userPassword);


    /**
     * 获取用户表总记录数（改过）
     *
     * @return
     * @throws Exception
     */
    public int getUserCounts();


    /**
     * 查询用户表集合信息（改过）
     *
     * @return
     * @throws
     */
    public List<User> getUserListInfo(@Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize);


    /**
     * 通过userId删除user（改过）
     *
     * @param delId
     * @return
     * @throws Exception
     */
    public int deleteUserByIds(@Param("id") Integer delId);

}