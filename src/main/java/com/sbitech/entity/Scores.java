package com.sbitech.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Scores {   //成绩实体类
    private Long id;    // 主键ID
    private Long playerMatchId; //参赛记录ID
    private Float score;    // 成绩
    private Boolean isArtificial;   //0未干预 1有干预
    private Float afterScore;   //干预后的分数
}
