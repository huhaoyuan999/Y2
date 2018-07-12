package com.mybatis.dao;

import com.mybatis.pojo.Role;

/**
 * 角色表实体类
 */
public interface RoleMapper {

    /**
     * 添加用户信息
     * @return
     */
    public int insertRoleInfo(Role role);

}
