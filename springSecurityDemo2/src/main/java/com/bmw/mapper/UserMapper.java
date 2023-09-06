package com.bmw.mapper;

import org.springframework.stereotype.Repository;
import com.bmw.pojo.Role;
import com.bmw.pojo.User;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 通过用户名获取用户信息
     *
     * @param username 用户名
     * @return User 用户信息
     */
    User loadUserByUsername(String username);

    /**
     * 通过用户id获取用户角色集合
     *
     * @param userId 用户id
     * @return List<Role> 角色集合
     */
    List<Role> getUserRolesByUserId(Integer userId);
}
