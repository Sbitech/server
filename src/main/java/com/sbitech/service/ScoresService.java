package com.sbitech.service;

import com.sbitech.dto.AllScoresDTO;
import com.sbitech.dto.UpdateScoreDTO;
import com.sbitech.entity.Scores;

public interface ScoresService {
    Boolean updateScore(UpdateScoreDTO updateScoreDTO);

    AllScoresDTO getAllScores(Long playerMatchId);

    String getScoreByPlayerMatchesId(Long eventId,Long playerId);

}
