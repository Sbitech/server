package com.sbitech.controller;

import com.sbitech.dto.AllScoresDTO;
import com.sbitech.dto.UpdateScoreDTO;
import com.sbitech.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoresService scoresService;

    @PutMapping("/updateScore")
    public Boolean updateScore(@RequestBody UpdateScoreDTO updateScoreDTO) {
        System.out.println(updateScoreDTO);
        return scoresService.updateScore(updateScoreDTO);

    }

    @GetMapping("/getAllScores")
    public AllScoresDTO getAllScores(Long playerMatchId) {
        return scoresService.getAllScores(playerMatchId);
    }


}
