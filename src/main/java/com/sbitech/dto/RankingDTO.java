package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RankingDTO {

    private Long playerId;  //选手id
    private Integer ranking;   //名次
    private String playerName;  //选手姓名
    private String teamName;    //队伍名称
    private BigDecimal finalScore;  //最终成绩


}
