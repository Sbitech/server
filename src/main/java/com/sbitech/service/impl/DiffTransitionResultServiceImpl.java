package com.sbitech.service.impl;

import com.sbitech.dto.DiffTransitionResultDTO;
import com.sbitech.entity.DiffTransitionResult;
import com.sbitech.mapper.DiffTransitionResultMapper;
import com.sbitech.service.DiffTransitionResultService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiffTransitionResultServiceImpl implements DiffTransitionResultService {

    @Autowired
    private DiffTransitionResultMapper diffTransitionResultMapper;

    @Override
    public boolean upDiffTransitionResult(DiffTransitionResult diffTransitionResult) {  //将视频解析结果编译持久化

        val details = String.join(",", diffTransitionResult.getDetails());
        val failedReason = String.join(",", diffTransitionResult.getFailedReason());

        val diffTransitionResultDTO = new DiffTransitionResultDTO();

        diffTransitionResultDTO.setMoveId(diffTransitionResult.getMoveId());
        diffTransitionResultDTO.setMoveName(diffTransitionResult.getMoveName());
        diffTransitionResultDTO.setDifficultyScore(diffTransitionResult.getDifficultyScore());
        diffTransitionResultDTO.setTransitionScore(diffTransitionResult.getTransitionScore());
        diffTransitionResultDTO.setDetails(details);
        diffTransitionResultDTO.setFailedReason(failedReason);
        diffTransitionResultDTO.setMoveQualityScore(diffTransitionResult.getMoveQualityScore());
        diffTransitionResultDTO.setMovePerformanceScore(diffTransitionResult.getMovePerformanceScore());
        diffTransitionResultDTO.setJumpHeight(diffTransitionResult.getJumpHeight());
        diffTransitionResultDTO.setTurnBodyAngle(diffTransitionResult.getTurnBodyAngle());
        diffTransitionResultDTO.setHitLegAngle(diffTransitionResult.getHitLegAngle());
        diffTransitionResultDTO.setRunupSteps(diffTransitionResult.getRunupSteps());

        return diffTransitionResultMapper.upDiffTransitionResult(diffTransitionResultDTO);
    }

    @Override
    public DiffTransitionResult getDiffTransitionResult() { //从数据库获取最新的视频解析结果

        DiffTransitionResultDTO dto = diffTransitionResultMapper.getDiffTransitionResult();

        DiffTransitionResult dtr = new DiffTransitionResult();
        dtr.setMoveId(dto.getMoveId());
        dtr.setMoveName(dto.getMoveName());
        dtr.setDifficultyScore(dto.getDifficultyScore());
        dtr.setTransitionScore(dto.getTransitionScore());
        dtr.setDetails(dto.getDetails().split(","));
        dtr.setFailedReason(dto.getFailedReason().split(","));
        dtr.setMoveQualityScore(dto.getMoveQualityScore());
        dtr.setMovePerformanceScore(dto.getMovePerformanceScore());
        dtr.setJumpHeight(dto.getJumpHeight());
        dtr.setTurnBodyAngle(dto.getTurnBodyAngle());
        dtr.setHitLegAngle(dto.getHitLegAngle());
        dtr.setRunupSteps(dto.getRunupSteps());
        return dtr;
    }
}
