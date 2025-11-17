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
    private Float transitionScore;
    private String details;

    private String failedReason;
    private Float moveQualityScore;
    private Float movePerformanceScore;

    private Float jumpHeight;
    private Float turnBodyAngle;
    private Float hitLegAngle;
    private Integer runupSteps;
}
