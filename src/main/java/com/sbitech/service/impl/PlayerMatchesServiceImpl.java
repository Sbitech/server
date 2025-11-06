package com.sbitech.service.impl;

import com.sbitech.dto.PlayerMatchInfoDTO;
import com.sbitech.dto.PlayerMatchesDTO;
import com.sbitech.dto.PlayerSkillInfoDTO;
import com.sbitech.entity.Move;
import com.sbitech.entity.PlayerInfo;
import com.sbitech.entity.PlayerMatches;
import com.sbitech.entity.Scores;
import com.sbitech.mapper.MoveMapper;
import com.sbitech.mapper.OrderMapper;
import com.sbitech.mapper.PlayerMatchesMapper;
import com.sbitech.mapper.ScoresMapper;
import com.sbitech.service.PlayerMatchesService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerMatchesServiceImpl implements PlayerMatchesService {
    @Autowired
    private PlayerMatchesMapper playerMatchesMapper;
    @Autowired
    private MoveMapper moveMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ScoresMapper scoresMapper;

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

        Map<String, Float> moveScoreCache = moveMapper.getAllMoves().stream()
                .collect(Collectors.toMap(Move::getCode, Move::getScore));

        for (PlayerInfo playerInfo : playerInfos) {
            PlayerSkillInfoDTO dto = new PlayerSkillInfoDTO();
            dto.setPlayerId(playerInfo.getId());
            dto.setPlayerName(playerInfo.getRealName());

            Map<String, Float> moveScoreMap = new LinkedHashMap<>();
            PlayerMatches playerMatches = playerMatchesMapper.getByUserId(playerInfo.getId());
            if (playerMatches == null || playerMatches.getMoveList() == null) {
                matchInfo.add(dto);
                continue;
            }

            String[] moveList = playerMatches.getMoveList().split(",");
            for (String key : moveList) {
                // 从缓存 Map 中直接取分数，避免数据库查询
                Float score = moveScoreCache.getOrDefault(key, 0f);
                moveScoreMap.put(key, score);
            }

            dto.setSkills(moveScoreMap);
            matchInfo.add(dto);
        }
        return matchInfo;
    }

    @Override
    public PlayerMatchesDTO getPlayerMatchesById(Long id) {

        PlayerMatchesDTO playerMatches = playerMatchesMapper.getPlayerMatchesById(id);
        val moveList = moveMapper.getMoveListByPlayerMatchesId(playerMatches.getPlayerMatchesId());
        val scoreList = scoresMapper.getScoresByPlayerMatchesId(playerMatches.getPlayerMatchesId());
        String[] move = moveList.split(",");
        String[] score = scoreList.split(",");

        Map<String, Float> moveMap = new LinkedHashMap<String, Float>();
//        for(String key:move){
        for (int i = 0; i < move.length; i++) {
            moveMap.put(move[i], Float.valueOf(score[i]));
        }
        playerMatches.setMoveInfo(moveMap);
        return playerMatches;
    }

    @Override
    public List<PlayerMatchInfoDTO> getAllPlayerMatch() {
        return playerMatchesMapper.getAllPlayerMatch();

    }
}
