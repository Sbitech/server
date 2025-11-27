package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notifications {
    private Long id; //id
    private Long refereeId; //裁判id
    private String title; //标题
    private String content; //内容
    private Short type; //0系统通知 1评分处理 2申诉处理
    private Short isRead; //是否已读
    private Timestamp time; //通知时间
}
