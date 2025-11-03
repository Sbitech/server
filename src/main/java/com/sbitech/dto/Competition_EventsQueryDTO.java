package com.sbitech.dto;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Competition_EventsQueryDTO {

//    ---- Competition -----
    private String competitionId;      // 比赛ID
    private String competitionName;    // 比赛名称
    private Timestamp startDate;       // 开始日期
    private Timestamp endDate;         // 结束日期
    private String location;            // 比赛地点
    private String hostOrganization;    // 主办单位
    private Integer eventLevel;        // 比赛级别
    private String status;              // 比赛状态

//    ---- Events -----
    private String id;            // 项目ID
    private String name;          // 项目名称
    private String category;            // 项目类别
    private String rules;         // 规则
    private Timestamp startTime;    // 开始时间
}
