package com.sbitech.controller;

import com.sbitech.dto.CompetitionDTO;
import com.sbitech.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 比赛控制器
 */

@RestController
@CrossOrigin
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping("/getCompetitionByTime")
    public CompetitionDTO getCompetitionByTime() {
        return competitionService.getCompetitionByTime();
    }

}
