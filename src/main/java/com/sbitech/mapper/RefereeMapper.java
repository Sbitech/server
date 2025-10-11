package com.sbitech.mapper;

import com.sbitech.entity.Referee;
import com.sbitech.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RefereeMapper {
    Referee exist(String username, String password);

    Referee selectByUsername(String username);
    
    /**
     * 根据用户名查询裁判信息，包含角色信息
     * @param username 用户名
     * @return 裁判信息（包含角色）
     */
    Referee selectByUsernameWithRole(@Param("username") String username);
}