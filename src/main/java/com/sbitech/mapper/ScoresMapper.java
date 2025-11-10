package com.sbitech.mapper;

import com.sbitech.dto.AllScoresDTO;
import com.sbitech.dto.RankingDTO;
import com.sbitech.dto.UpdateScoreDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ScoresMapper {
    String getScoresByPlayerMatchesId(Long playerMatchesId);

    Boolean updateScore(UpdateScoreDTO updateScoreDTO);

    AllScoresDTO getAllScoresByPlayerMatchId(Long playerMatchId);

    List<Long> getRankingByPlayerMatchId(Long eventId);

    String getScoreByPlayerMatchesId(Long eventId,Long playerId);

    List<RankingDTO> getRanking(Long eventId);
}
