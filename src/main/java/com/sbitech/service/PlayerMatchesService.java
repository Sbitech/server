package com.sbitech.service;

import com.sbitech.dto.PlayerSkillInfoDTO;
import com.sbitech.entity.PlayerMatches;

import java.util.List;
import java.util.Map;

public interface PlayerMatchesService {
    List<PlayerMatches> getAll();

    PlayerMatches getById(Long id);

    List<PlayerSkillInfoDTO> getPlayerMoveById(Long eventId);
}
