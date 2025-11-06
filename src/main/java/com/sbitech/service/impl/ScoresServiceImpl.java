package com.sbitech.service.impl;

import com.sbitech.dto.UpdateScoreDTO;
import com.sbitech.mapper.ScoresMapper;
import com.sbitech.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoresServiceImpl implements ScoresService {
    @Autowired
    private ScoresMapper scoresMapper;

    @Override
    public Boolean updateScore(UpdateScoreDTO updateScoreDTO) {
        return scoresMapper.updateScore(updateScoreDTO);
    }
}
