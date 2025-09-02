package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Referee { // 裁判实体类

    private Long id;    // 主键ID
    private String username;    // 用户名
    private String password;    // 密码
    private String name;    // 真实姓名
    private String phone;   // 联系电话

}
