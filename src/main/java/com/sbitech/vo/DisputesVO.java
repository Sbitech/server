package com.sbitech.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DisputesVO {
    private Long id;    //id
    private Long playMatchId; //比赛记录id
    private Long title; //申诉标题
    private String evidenceUrl; //证据材料url
    private String status; //申诉状态（1:待处理、2:已处理、3:驳回）
    private Timestamp createTime; //创建时间
    private Timestamp reviewTime; //审核时间
    private String category; // 项目类别


}
