package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSkillInfoDTO {
    private Long playerId;
    private String playerName;
    private Map<String, Float> skills;
}
