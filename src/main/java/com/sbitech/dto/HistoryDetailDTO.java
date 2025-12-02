package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HistoryDetailDTO {

    private Long id;    //选手id
    private String playerName;  // 选手姓名
    private String eventName;   //比赛项目
    private String playerMatchTime; //选手比赛时间
    private String status;      //比赛状态

    private Long eventId;      // 项目ID
    private Long playerMatchId; // 参赛记录ID
    private String scoresOfA;   // A组裁判得分
    private String scoresOfB;   // B组裁判得分
    private String scoresOfC;   // C组裁判得分
    private BigDecimal finalScoreOfA=BigDecimal.ZERO;   // 最终得分
    private BigDecimal finalScoreOfB=BigDecimal.ZERO;   // 最终得分
    private BigDecimal finalScoreOfC=BigDecimal.ZERO;   // 最终得分
    private Integer ranking;     // 名次
    private BigDecimal AllFinalScore=BigDecimal.ZERO; // 总分

}
