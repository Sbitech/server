package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolePermission {
    private Long id;            // 主键ID
    private Long roleId;        // 角色ID
    private Long permissionId;  // 权限ID
}