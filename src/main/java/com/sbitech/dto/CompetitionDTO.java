package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CompetitionDTO {

    private String CompetitionId;
    private String CompetitionName;
    private Map<Long , String> eventsInfo;

}
