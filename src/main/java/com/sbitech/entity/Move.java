package com.sbitech.entity;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Move {

    private String code;    //招式代码
    private String move_name;   //招式名
    private String move_type;   //招式类型
    private String score1;  //分值（A,B,C,D）
    private Float score;    //分值
    private String category;    //单独招式类别

}
