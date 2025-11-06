package com.sbitech.mapper;

import com.sbitech.dto.UpdateScoreDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoresMapper {
    String getScoresByPlayerMatchesId(Long playerMatchesId);

    Boolean updateScore(UpdateScoreDTO updateScoreDTO);
}
