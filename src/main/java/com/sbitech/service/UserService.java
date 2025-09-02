package com.sbitech.service;

import com.sbitech.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getUsers();


    User login(User user);
}
