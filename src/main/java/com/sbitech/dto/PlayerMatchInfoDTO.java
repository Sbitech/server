package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerMatchInfoDTO {
    private Long playerMatchesId;   // 参赛记录ID
    private Long playerId;  // 参赛者ID

    private String eventName;    // 项目名称
    private String eventCategory; // 项目类别
    private Timestamp eventTime; // 开始时间

    private String realName;    // 真实姓名
    private String teamName;    // 队伍名称
}
