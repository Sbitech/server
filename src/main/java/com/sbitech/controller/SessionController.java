package com.sbitech.controller;

import com.sbitech.entity.Session;
import com.sbitech.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/generate")
    public String generateSession(@RequestBody Session session) {
        return sessionService.generateSession(session);
    }

    @GetMapping("/getSession")
    public Session getSession(@RequestParam  UUID sessionToken) {
//        UUID sessionUUID = UUID.fromString(sessionToken);
        System.err.println("sessionToken: " + sessionToken);
        return sessionService.getSession(sessionToken);
    }

}
