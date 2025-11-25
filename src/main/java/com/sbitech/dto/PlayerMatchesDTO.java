package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerMatchesDTO {

    private Long playerMatchesId;   // 参赛记录ID
    private Timestamp matchTime; // 开始时间

    private String eventName;    // 项目名称
    private String eventCategory; // 项目类别

    private Long playerInfoId; // 参赛者ID
    private String realName;    // 真实姓名
    private String teamName;    // 队伍名称

    private String fileUrl;    // 视频录像URL
    private Timestamp uploadedTime; // 上传时间
    private List<MoveScoreDTO> moveScoreList;

}
