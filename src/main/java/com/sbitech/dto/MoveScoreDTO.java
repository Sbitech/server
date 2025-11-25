package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MoveScoreDTO {

    private String code; // 新增：动作 code（字符串），比 moveId 更可靠
    private String moveName;
    private Float score;

}
