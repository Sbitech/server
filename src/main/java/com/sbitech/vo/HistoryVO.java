package com.sbitech.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class HistoryVO {

    //play_matches  比赛记录
    private Long id;
    private Long eventsId;
    private Long userId;
    private String playerNumber;
    private String status;
    private Timestamp time;

    //user  用户
    private String username;
    private String realName;
    private String team;
    private String phone;

    //events    项目信息
    private String category;
    private String eventName;
    private String rules;

    //scores    成绩
    private String scoreListC;

}
