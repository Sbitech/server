package com.sbitech.service;

import com.sbitech.dto.AllScoresDTO;
import com.sbitech.dto.RankingDTO;
import com.sbitech.dto.UpdateScoreDTO;
import java.util.List;

public interface ScoresService {
    Boolean updateScore(UpdateScoreDTO updateScoreDTO);

    AllScoresDTO getAllScores(Long playerMatchId);

    String getScoreByPlayerMatchesId(Long eventId,Long playerId);

    List<RankingDTO> getRanking(Long eventId);
}
