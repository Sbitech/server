package com.sbitech.mapper;

import com.sbitech.entity.Session;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SessionMapper {
    void generateSession(Session session);
}
