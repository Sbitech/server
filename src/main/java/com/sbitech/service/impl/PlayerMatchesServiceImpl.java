package com.sbitech.service.impl;

import com.sbitech.dto.MoveScoreDTO;
import com.sbitech.dto.PlayerMatchInfoDTO;
import com.sbitech.dto.PlayerMatchesDTO;
import com.sbitech.dto.PlayerSkillInfoDTO;
import com.sbitech.entity.Move;
import com.sbitech.entity.PlayerInfo;
import com.sbitech.entity.PlayerMatches;
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
    public PlayerMatches getById(Long eventId, Long id) {
        return playerMatchesMapper.getByUserId(eventId, id);
    }

    @Override
    public List<PlayerSkillInfoDTO> getPlayerMoveById(Long eventId) {   //通过赛事id获取选手出场顺序和选手的招式列表以及招式分数

        List<PlayerSkillInfoDTO> matchInfo = new LinkedList<>();

        List<PlayerInfo> playerInfos = orderMapper.getRankingByEventId(eventId);    //获取该赛事的选手出场顺序

        Map<String, Float> moveScoreCache = moveMapper.getAllMoves().stream()   //获取所有动作及其分数，缓存进 Map
                .collect(Collectors.toMap(Move::getCode, Move::getScore));

        for (PlayerInfo playerInfo : playerInfos) { //遍历选手列表
            PlayerSkillInfoDTO dto = new PlayerSkillInfoDTO();
            dto.setPlayerId(playerInfo.getId());
            dto.setPlayerName(playerInfo.getRealName());

            Map<String, Float> moveScoreMap = new LinkedHashMap<>();
            PlayerMatches playerMatches = playerMatchesMapper.getByUserId(eventId, playerInfo.getId());  //把选手对应的比赛动作取出来
            if (playerMatches == null || playerMatches.getMoveList() == null) {
                matchInfo.add(dto);
                continue;
            }

            String[] moveList = playerMatches.getMoveList().split(",");
            for (String key : moveList) {   //遍历选手的动作列表
                Float score = moveScoreCache.getOrDefault(key, 0f);
                moveScoreMap.put(key, score);
            }

            dto.setSkills(moveScoreMap);    //把选手的动作和对应分数放进 dto
            matchInfo.add(dto);
        }
        return matchInfo;
    }

    @Override
    public PlayerMatchesDTO getPlayerMatchesById(Long id) { //通过比赛场次id获取选手比赛的招式和对应的成绩

        PlayerMatchesDTO playerMatches = playerMatchesMapper.getPlayerMatchesById(id);
        val moveList = moveMapper.getMoveListByPlayerMatchesId(playerMatches.getPlayerMatchesId());
        val scoreList = scoresMapper.getScoresByPlayerMatchesId(playerMatches.getPlayerMatchesId());
        String[] move = moveList.split(",");
        String[] score = scoreList.split(",");

        ArrayList<MoveScoreDTO> moveInfoList = new ArrayList<>();
        for (int i = 0; i < move.length; i++) {
            MoveScoreDTO moveScoreDTO = new MoveScoreDTO();
            moveScoreDTO.setCode(move[i]);
            moveScoreDTO.setScore(Float.valueOf(score[i]));
            moveScoreDTO.setMoveName(moveMapper.getNameByCode(move[i]));
            moveInfoList.add(moveScoreDTO);
        }
        playerMatches.setMoveScoreList(moveInfoList);
        return playerMatches;
    }

    @Override
    public List<PlayerMatchInfoDTO> getAllPlayerMatch() {
        return playerMatchesMapper.getAllPlayerMatch();

    }

    @Override
    public List<PlayerMatchInfoDTO> getAllInfoByEventId(Long eventId) {
        System.out.println(playerMatchesMapper.getAllInfoByEventId(eventId));
        return playerMatchesMapper.getAllInfoByEventId(eventId);
    }

}
