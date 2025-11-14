package com.sbitech.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DiffTransitionResult {

    @JsonProperty("diff_score")
    private Float diffScore;
    @JsonProperty("diff_failed_reason")
    private String[] diffFailedReason;
    @JsonProperty("transition_score")
    private Float transitionScore;
    @JsonProperty("transition_failed_reason")
    private String[] transitionFailedReason;

}
