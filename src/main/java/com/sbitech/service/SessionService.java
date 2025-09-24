package com.sbitech.service;

import com.sbitech.entity.Session;

import java.util.UUID;

public interface SessionService {

    String generateSession(Session session);

    Session getSession(UUID sessionToken);
}
