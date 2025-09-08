package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {   //签到实体类

    private Long id;    // 主键ID
    private Long userId;    //用户ID
    private Timestamp signFirst;    //第一次签到时间
    private Timestamp signSecond;   //第二次签到时间
    private Timestamp signThird;    //第三次签到时间

}
