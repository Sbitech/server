package com.sbitech.mapper;

import com.sbitech.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UsersMapper {

    List<Users> getUsers();

    Users isExist(String username, String password);
}
