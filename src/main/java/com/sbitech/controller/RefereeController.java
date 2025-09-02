package com.sbitech.controller;

import com.sbitech.entity.Referee;
import com.sbitech.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/referee")
public class RefereeController {
    @Autowired
    private RefereeService refereeService;


    @PostMapping("/login")
    public Referee login(@RequestBody  Referee referee) {
        Referee login = refereeService.login(referee);
        if (login != null) {
            login.setPassword(null);    //剔除敏感信息
            login.setPhone(null);
        }
        return login;
    }

}
