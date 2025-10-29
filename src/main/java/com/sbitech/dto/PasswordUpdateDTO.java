package com.sbitech.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasswordUpdateDTO {
    private String username;      // 用户名
    private String oldPassword;   // 旧密码
    private String newPassword;   // 新密码
}