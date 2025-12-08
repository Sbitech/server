package com.sbitech.controller;

import com.sbitech.dto.AllScoresDTO;
import com.sbitech.dto.RankingDTO;
import com.sbitech.dto.UpdateScoreDTO;
import com.sbitech.service.ScoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {

    private final ScoresService scoresService;

    @PutMapping("/updateScore")
    public Boolean updateScore(@RequestBody UpdateScoreDTO updateScoreDTO) {
        System.out.println(updateScoreDTO);
        return scoresService.updateScore(updateScoreDTO);
    }

    @GetMapping("/getAllScores")
    public AllScoresDTO getAllScores(Long playerMatchId) {
        return scoresService.getAllScores(playerMatchId);
    }

    @GetMapping("getScoreByPlayerMatchesId")
    public String getScoreByPlayerMatchesId(Long eventId,Long playerId) {
        return scoresService.getScoreByPlayerMatchesId(eventId,playerId);
    }

    @GetMapping("/getRanking")
    public List<RankingDTO> getRanking(Long eventId) {
        return scoresService.getRanking(eventId);
    }

}
