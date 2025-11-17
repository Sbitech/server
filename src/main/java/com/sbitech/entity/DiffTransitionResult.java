package com.sbitech.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DiffTransitionResult {


    @JsonProperty("move_id")
    private Long moveId;
    @JsonProperty("move_name")
    private String moveName;

    @JsonProperty("difficulty_score")
    private Float difficultyScore;

    @JsonProperty("transition_score")
    private Float transitionScore;


    private String[] details;   //

    @JsonProperty("failed_reason")
    private String[] failedReason;
    @JsonProperty("move_quality_score")
    private Float moveQualityScore;
    @JsonProperty("move_performance_score")
    private Float movePerformanceScore;

    @JsonProperty("jump_height")
    private Float jumpHeight;
    @JsonProperty("turn_body_angle")
    private Float turnBodyAngle;
    @JsonProperty("hit_leg_angle")
    private Float hitLegAngle;
    @JsonProperty("runup_steps")
    private Integer runupSteps;

}
