package com.sbitech.mapper;

import com.sbitech.dto.PlayerMatchInfoDTO;
import com.sbitech.dto.PlayerMatchesDTO;
import com.sbitech.entity.PlayerMatches;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayerMatchesMapper {
    List<PlayerMatches> getAll();

    PlayerMatches getByUserId(Long id);

    PlayerMatchesDTO getPlayerMatchesById(Long id);

    List<PlayerMatchInfoDTO> getAllPlayerMatch();

}
