package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users { // 用户实体类

    private Long id;    // 主键ID
    private String username;    // 用户名
    private String password;    // 密码
    private String realName;    // 真实姓名
    private String numberID;    // 身份证号
    private String team;    // 所属队伍
    private String phone;   // 联系电话

}
