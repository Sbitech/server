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
    public boolean upDiffTransitionResult(DiffTransitionResult diffTransitionResult) {
        val transitionFailedReason = String.join(",", diffTransitionResult.getTransitionFailedReason());
        val diffFailedReason = String.join(",", diffTransitionResult.getDiffFailedReason());
        val diffTransitionResultDTO = new DiffTransitionResultDTO();

        diffTransitionResultDTO.setTransitionFailedReason(transitionFailedReason);
        diffTransitionResultDTO.setTransitionScore(diffTransitionResult.getTransitionScore());
        diffTransitionResultDTO.setDiffFailedReason(diffFailedReason);
        diffTransitionResultDTO.setDiffScore(diffTransitionResult.getDiffScore());

        return diffTransitionResultMapper.upDiffTransitionResult(diffTransitionResultDTO);
    }

    @Override
    public DiffTransitionResult getDiffTransitionResult() {

        DiffTransitionResultDTO dto = diffTransitionResultMapper.getDiffTransitionResult();

        DiffTransitionResult dtr = new DiffTransitionResult();
        dtr.setDiffScore(dto.getDiffScore());
        dtr.setTransitionFailedReason(dto.getTransitionFailedReason().split(","));
        dtr.setTransitionScore(dto.getTransitionScore());
        dtr.setDiffFailedReason(dto.getDiffFailedReason().split(","));
        return dtr;
    }
}
