package com.sbitech.mapper;

import com.sbitech.entity.PlayerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

 public interface OrderMapper {
    List<PlayerInfo> getRankingByEventId(Long eventId);
}
