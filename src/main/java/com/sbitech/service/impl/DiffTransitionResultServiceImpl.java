package com.sbitech.service.impl;

import com.sbitech.dto.DiffTransitionResultDTO;
import com.sbitech.entity.DiffTransitionResult;
import com.sbitech.mapper.DiffTransitionResultMapper;
import com.sbitech.service.DiffTransitionResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiffTransitionResultServiceImpl implements DiffTransitionResultService {

    private final DiffTransitionResultMapper diffTransitionResultMapper;

    public boolean upDiffTransitionResult(DiffTransitionResult diffTransitionResult) {  //将视频解析结果编译持久化
        if (diffTransitionResult == null) return false;

        String details = diffTransitionResult.getDetails() == null ? "" : String.join(",", diffTransitionResult.getDetails());
        String failedReason = diffTransitionResult.getFailedReason() == null ? "" : String.join(",", diffTransitionResult.getFailedReason());

        DiffTransitionResultDTO dto = new DiffTransitionResultDTO();
        dto.setMoveId(diffTransitionResult.getMoveId());
        dto.setMoveName(diffTransitionResult.getMoveName());
        dto.setDifficultyScore(diffTransitionResult.getDifficultyScore());
        dto.setTransitionScore(diffTransitionResult.getTransitionScore());
        dto.setDetails(details);
        dto.setFailedReason(failedReason);
        dto.setMoveQualityScore(diffTransitionResult.getMoveQualityScore());
        dto.setMovePerformanceScore(diffTransitionResult.getMovePerformanceScore());
        dto.setJumpHeight(diffTransitionResult.getJumpHeight());
        dto.setTurnBodyAngle(diffTransitionResult.getTurnBodyAngle());
        dto.setHitLegAngle(diffTransitionResult.getHitLegAngle());
        dto.setRunupSteps(diffTransitionResult.getRunupSteps());

        return diffTransitionResultMapper.upDiffTransitionResult(dto);
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
