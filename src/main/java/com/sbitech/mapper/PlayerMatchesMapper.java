package com.sbitech.mapper;

import com.sbitech.entity.PlayerMatches;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayerMatchesMapper {
    List<PlayerMatches> getAll();

    PlayerMatches getByUserId(Long id);
}
