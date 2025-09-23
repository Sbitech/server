package com.sbitech.service.impl;

import com.sbitech.entity.Users;
import com.sbitech.mapper.UsersMapper;
import com.sbitech.mapper.UsersMapper;
import com.sbitech.service.UsersService;
import com.sbitech.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper userMapper;

    @Override
    public List<Users> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public Users login(Users user) {
        System.out.println(user);
        String username = user.getUsername();
        String password = user.getPassword();
        return userMapper.isExist(username, password);
    }

}
