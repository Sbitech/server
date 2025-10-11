package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Permission {
    private Long id;                    // 权限ID
    private String permissionCode;      // 权限编码（如：referee:add, referee:delete）
    private String permissionName;      // 权限名称
    private String description;         // 权限描述
}