package com.sbitech.mapper;

import com.sbitech.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    Role getRoleById(Long roleId);
}
