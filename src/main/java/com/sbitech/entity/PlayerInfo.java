package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerInfo { // 参赛选手实体类

    private Long id;    // 主键ID
    private String username;    // 用户名
    private String password;    // 密码
    private String realName;    // 真实姓名
    private String numberID;    // 身份证号
    private String team;    // 所属队伍
    private String phone;   // 联系电话
    private String gender;  // 性别   女：0 男：1 其他：2
    private Timestamp dateOfBirth;  // 出生日期
    private String nationality; // 国籍
    private String teamId;  //队伍id
    private String teamName;    //队伍名称
    private Float weight;   //体重
    private Float height;   //身高
    private String discipline;  //擅长类型
    private String registrationStatus; //注册状态：active=现役，inactive=退役，suspended=禁赛
    private Timestamp created_at;   //创建时间
    private Timestamp updated_at;   //更新时间
    private Object routine_info;    //存储自选套路信息(从报名数据库同步到此表)

}
