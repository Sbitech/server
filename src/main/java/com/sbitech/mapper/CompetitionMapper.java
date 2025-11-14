package com.sbitech.mapper;

import com.sbitech.dto.CompetitionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface CompetitionMapper {
    CompetitionDTO getCompetitionByTime(Timestamp nowTime);
}
