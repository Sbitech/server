package com.sbitech.controller;

import com.sbitech.entity.Session;
import com.sbitech.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
