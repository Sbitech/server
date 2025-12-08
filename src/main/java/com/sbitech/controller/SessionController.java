package com.sbitech.controller;

import com.sbitech.entity.Session;
import com.sbitech.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

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
