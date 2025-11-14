package com.sbitech.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DiffTransitionResultDTO {

    private Long moveId;
    private String moveName;
    private Float difficultyScore;
    private String diffFailedReason;
    private Float transitionScore;
    private String transitionFailedReason;

    private Float moveQualityScore;
    private Float movePerformanceScore;

}
