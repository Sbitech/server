package com.sbitech.service.impl;

import com.sbitech.dto.AllScoresDTO;
import com.sbitech.dto.UpdateScoreDTO;
import com.sbitech.entity.Scores;
import com.sbitech.mapper.ScoresMapper;
import com.sbitech.service.ScoresService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ScoresServiceImpl implements ScoresService {
    @Autowired
    private ScoresMapper scoresMapper;

    @Override
    public Boolean updateScore(UpdateScoreDTO updateScoreDTO) {
        String scoreListC = updateScoreDTO.getScoreListC();
        String[] cList = scoreListC.split(",");
        for (String s : cList) {
            updateScoreDTO.setScoreC(Float.parseFloat(s)+updateScoreDTO.getScoreC());
        }
        return scoresMapper.updateScore(updateScoreDTO);
    }

    @Override
    public AllScoresDTO getAllScores(Long playerMatchId) {
        AllScoresDTO allScoresDTO = new AllScoresDTO();
        allScoresDTO=scoresMapper.getAllScoresByPlayerMatchId(playerMatchId);

        allScoresDTO.setPlayerMatchId(playerMatchId);
        String scoreOfC = allScoresDTO.getScoresOfC();
        String[] scoreC = scoreOfC.split(",");
        BigDecimal totalC=BigDecimal.ZERO;
        for (String s : scoreC) {   //成绩相加获得C组最终得分
            BigDecimal value= new BigDecimal(s);
            totalC=totalC.add(value);
        }
        allScoresDTO.setFinalScoreOfC(totalC);
        System.out.println(totalC);

        allScoresDTO.setAllFinalScore(  //计算最终成绩
                allScoresDTO.getFinalScoreOfA()
                        .add(allScoresDTO.getFinalScoreOfB())
                        .add(allScoresDTO.getFinalScoreOfC())
        );

        List<Long> rankingList = scoresMapper.getRankingByPlayerMatchId(allScoresDTO.getEventId());
        Integer ranking = rankingList.indexOf(allScoresDTO.getPlayerMatchId());

        allScoresDTO.setRanking(ranking+1);

        return allScoresDTO;
    }
}
