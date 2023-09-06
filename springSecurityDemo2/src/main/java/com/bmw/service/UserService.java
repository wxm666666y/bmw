package com.bmw.service;

import com.bmw.mapper.UserMapper;
import com.bmw.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    //loadUserByUsername(String s) ,s是用户登录时输入的账户名，这个方法就是通过用户输入的账户名判断该账户是否存在，
    //存在才进行用户角色信息的查找，然后才有DaoAuthenticationProvider校验密码
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在！");
        }

        user.setRoles(userMapper.getUserRolesByUserId(user.getId()));
        return user;
    }
}
