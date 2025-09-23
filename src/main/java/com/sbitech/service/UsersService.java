package com.sbitech.service;

import com.sbitech.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersService {

    List<Users> getUsers();


    Users login(Users user);
}
