package com.sbitech.service.impl;

import com.sbitech.entity.Session;
import com.sbitech.mapper.SessionMapper;
import com.sbitech.service.SessionService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public String generateSession(Session session) {
        session.setSessionToken(UUID.randomUUID()); //生成token UUID

        val format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));    //获取当前时间
        val timestamp = Timestamp.valueOf(format);
        session.setCreatedAt(timestamp);
        System.err.println(session);
        sessionMapper.generateSession(session);
        return session.getSessionToken().toString();
    }

    @Override
    public Session getSession(UUID sessionToken) {
        return sessionMapper.getSessionToken(sessionToken);
    }

}
