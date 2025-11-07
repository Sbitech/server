package com.sbitech.service;

import com.sbitech.dto.AllScoresDTO;
import com.sbitech.dto.UpdateScoreDTO;

public interface ScoresService {
    Boolean updateScore(UpdateScoreDTO updateScoreDTO);

    AllScoresDTO getAllScores(Long playerMatchId);
}
