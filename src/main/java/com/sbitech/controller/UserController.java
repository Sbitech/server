package com.sbitech.controller;

import com.sbitech.entity.User;
import com.sbitech.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        val login = userService.login(user);
        if(login != null){
            login.setPassword(null);    //剔除敏感信息
            login.setNumberID(null);
        }
        return login;
    }

}
