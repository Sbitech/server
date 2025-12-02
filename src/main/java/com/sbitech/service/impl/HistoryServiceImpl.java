package com.sbitech.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbitech.dto.AllScoresDTO;
import com.sbitech.dto.HistoryDetailDTO;
import com.sbitech.dto.HistoryQueryDTO;
import com.sbitech.mapper.HistoryMapper;
import com.sbitech.service.HistoryService;
import com.sbitech.service.ScoresService;
import com.sbitech.vo.HistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private ScoresService scoresService;

    @Override
    public PageInfo<HistoryVO> getHistoryByCondition(HistoryQueryDTO queryDTO) { //获取历史属于的分页数据
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<HistoryVO> history = historyMapper.historyPage(
                queryDTO.getStartTime(),
                queryDTO.getEndTime(),
                queryDTO.getCategory(),
                queryDTO.getName()
        );
        return new PageInfo<>(history);
    }

    @Override
    public HistoryDetailDTO getDetail(Long id) {
        HistoryDetailDTO dto=historyMapper.getDetail(id);
        AllScoresDTO allScores = scoresService.getAllScores(id);

        dto.setScoresOfA(allScores.getScoresOfA());
        dto.setScoresOfB(allScores.getScoresOfB());
        dto.setScoresOfC(allScores.getScoresOfC());
        dto.setFinalScoreOfA(allScores.getFinalScoreOfA());
        dto.setFinalScoreOfB(allScores.getFinalScoreOfB());
        dto.setFinalScoreOfC(allScores.getFinalScoreOfC());
        dto.setRanking(allScores.getRanking());
        dto.setAllFinalScore(allScores.getAllFinalScore());

        return dto;
    }
}
