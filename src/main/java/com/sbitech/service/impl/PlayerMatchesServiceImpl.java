package com.sbitech.service.impl;

import com.sbitech.dto.PlayerSkillInfoDTO;
import com.sbitech.entity.PlayerInfo;
import com.sbitech.entity.PlayerMatches;
import com.sbitech.mapper.MoveMapper;
import com.sbitech.mapper.OrderMapper;
import com.sbitech.mapper.PlayerMatchesMapper;
import com.sbitech.service.PlayerMatchesService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerMatchesServiceImpl implements PlayerMatchesService {
    @Autowired
    private PlayerMatchesMapper playerMatchesMapper;
    @Autowired
    private MoveMapper moveMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<PlayerMatches> getAll() {
        return playerMatchesMapper.getAll();
    }

    @Override
    public PlayerMatches getById(Long id) {
        return playerMatchesMapper.getByUserId(id);
    }

    @Override
    public List<PlayerSkillInfoDTO> getPlayerMoveById(Long eventId) {
        List<PlayerSkillInfoDTO> matchInfo = new LinkedList<>();
        List<PlayerInfo> playerInfos = orderMapper.getRankingByEventId(eventId);

        for (PlayerInfo playerInfo : playerInfos) {
            val playerSkillInfoDTO = new PlayerSkillInfoDTO();
            playerSkillInfoDTO.setPlayerId(playerInfo.getId());
            playerSkillInfoDTO.setPlayerName(playerInfo.getRealName());

            Map<String, Float> moveScoreMap = new LinkedHashMap<>();
            val playerMatches = playerMatchesMapper.getByUserId(playerInfo.getId());
            val moveList = playerMatches.getMoveList().split(",");
            for (String key : moveList) {
                val score = moveMapper.getByCode(key);
                moveScoreMap.put(key, score);
            }
            playerSkillInfoDTO.setSkills(moveScoreMap);
            matchInfo.add(playerSkillInfoDTO);
        }
        return matchInfo;
    }
}
