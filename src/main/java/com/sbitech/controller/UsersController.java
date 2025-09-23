package com.sbitech.controller;

import com.sbitech.entity.Users;
import com.sbitech.service.UsersService;
import com.sbitech.service.UsersService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService userService;

    @GetMapping("/all")
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/login")
    public Users login(@RequestBody Users users){
        val login = userService.login(users);
        if(login != null){
            login.setPassword(null);    //剔除敏感信息
            login.setNumberID(null);
        }
        return login;
    }

}
