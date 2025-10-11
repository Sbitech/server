package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Referee { // 裁判实体类

    private Long id;    // 主键ID
    private String username;    // 用户名
    private String password;    // 密码
    private String name;    // 真实姓名
    private String phone;   // 联系电话
    private Long roleId;  // 角色ID（对应role表）
    private Boolean enabled; // 是否启用
    
    // 非数据库字段，用于存储角色信息和权限列表
    private Role role;  // 角色信息
    private List<Permission> permissions; // 权限列表

}