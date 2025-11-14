package com.sbitech.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DiffTransitionResultDTO {

    private Float diffScore;
    private String diffFailedReason;
    private Float transitionScore;
    private String transitionFailedReason;

}
