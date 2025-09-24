package com.sbitech.mapper;

import com.sbitech.entity.Session;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
public interface SessionMapper {
    void generateSession(Session session);

    Session getSessionToken(@Param("sessionToken") UUID sessionToken);
}
