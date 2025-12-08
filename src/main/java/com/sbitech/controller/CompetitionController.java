package com.sbitech.controller;

import com.sbitech.dto.CompetitionDTO;
import com.sbitech.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 比赛控制器
 */

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/competition")
public class CompetitionController {

    private final CompetitionService competitionService;

    @GetMapping("/getCompetitionByTime")
    public CompetitionDTO getCompetitionByTime() {
        return competitionService.getCompetitionByTime();
    }

}
