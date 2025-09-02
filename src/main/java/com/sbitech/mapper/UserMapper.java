package com.sbitech.mapper;

import com.sbitech.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    List<User> getUsers();

    User isExist(String username, String password);
}
