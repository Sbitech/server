package com.sbitech.mapper;

import com.sbitech.dto.DiffTransitionResultDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiffTransitionResultMapper {
    boolean upDiffTransitionResult(DiffTransitionResultDTO diffTransitionResultDTO);

    DiffTransitionResultDTO getDiffTransitionResult();
}
