package com.sbitech.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DisputesDetailVO {

    //disputes
    private Long id;
    private Long playMatchId; //比赛记录id
    private String title; //申诉标题
    private String reason; //申诉理由
    private String evidenceUrl; //证据材料url
    private String status; //申诉状态（0:待处理、1:已处理、2:驳回）
    private String reviewOpinion; //审核意见
    private Timestamp createTime;   //创建时间
    private Timestamp reviewTime;   //审核时间

    //events
    private String name;    // 项目名称
    private String category; // 项目类别

    //scores
    private Float score;  //成绩

    //user
    private String realName; //真实姓名

}
