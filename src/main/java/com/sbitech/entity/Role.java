package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    private Long id;         // 角色ID
    private String roleName;     // 角色名称(如ADMIN, REFEREE)
    private String description; // 角色描述
}