package com.sbitech.mapper;

import com.sbitech.entity.Referee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RefereeMapper {
    Referee exist(String username, String password);
}
