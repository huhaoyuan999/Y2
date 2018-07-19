package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {

    /**
     * 查询全部信息
     * @return
     */
    public List<User> selectInfoAll();

    /**
     * 根据Id删除指定信息
     * @return
     */
    public int deleteInfoID(@Param("id")Integer id);

    /**
     * 修改指定用户名称
     * @param userName
     * @param id
     * @return
     */
    public int updateInfoID(@Param("name")String userName,@Param("id")Integer id);

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertInfo(User user);
}
