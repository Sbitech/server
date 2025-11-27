package com.sbitech.service;

import com.sbitech.dto.PlayerMatchInfoDTO;
import com.sbitech.dto.PlayerMatchesDTO;
import com.sbitech.dto.PlayerSkillInfoDTO;
import com.sbitech.entity.PlayerMatches;

import java.util.List;

public interface PlayerMatchesService {
    List<PlayerMatches> getAll();

    PlayerMatches getById(Long eventId,Long id);

    List<PlayerSkillInfoDTO> getPlayerMoveById(Long eventId);

    PlayerMatchesDTO getPlayerMatchesById(Long id);

    List<PlayerMatchInfoDTO> getAllPlayerMatch();

    List<PlayerMatchInfoDTO> getAllInfoByEventId(Long eventId);
}
