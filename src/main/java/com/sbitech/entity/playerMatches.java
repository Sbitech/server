package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class playerMatches {    //参赛记录表
    private Long id;    // 主键ID
    private Long eventId;   // 项目ID
    private Long userId;    // 参赛者ID
    private String playerNumber; // 参赛编号
    private Timestamp Time; //开始时间
    private String status;  //状态（0无争议 1有争议）
}
