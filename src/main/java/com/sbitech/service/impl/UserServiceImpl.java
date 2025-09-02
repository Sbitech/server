package com.sbitech.service.impl;

import com.sbitech.entity.User;
import com.sbitech.mapper.UserMapper;
import com.sbitech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public User login(User user) {
        System.out.println(user);
        String username = user.getUsername();
        String password = user.getPassword();
        return userMapper.isExist(username, password);
    }

}
