package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Events {   // 赛事项目实体类
    private Long id;    // 主键ID
    private String name;    // 项目名称
    private String category; // 项目类别
    private String rules;    // 规则说明
}
