package com.sbitech.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {  //会话实体类
    private Long id;
    private UUID sessionToken;      //会话token
    private Long userId;            //用户id
    private String userName;        //用户名
    private Long routineId;         //套路id
    private String routineName;     //套路名称
    private Long eventId;           //赛事id
    private String eventName;       //赛事名称
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp startTime;    //开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp endTime;      //结束时间
    private String status;          //状态（active/inactive）
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdAt;    //session创建时间
}
