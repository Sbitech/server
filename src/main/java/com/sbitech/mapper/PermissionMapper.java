package com.sbitech.mapper;

import com.sbitech.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {
    
    /**
     * 根据角色ID查询权限列表
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<Permission> findPermissionsByRoleId(@Param("roleId") Long roleId);
    
    /**
     * 根据裁判ID查询权限列表
     * @param refereeId 裁判ID
     * @return 权限列表
     */
    List<Permission> findPermissionsByRefereeId(@Param("refereeId") Long refereeId);
}