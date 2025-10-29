package com.sbitech.controller;

import com.sbitech.dto.PasswordUpdateDTO;
import com.sbitech.entity.PlayerInfo;
import com.sbitech.service.PlayerInfoService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/playerInfo")
public class PlayerInfoController {
    @Autowired
    private PlayerInfoService playerInfoService;

    @GetMapping("/all")
    public List<PlayerInfo> getUsers(){
        return playerInfoService.getUsers();
    }

    @PostMapping("/login")
    public PlayerInfo login(@RequestBody PlayerInfo users){
        val login = playerInfoService.login(users);
        if(login != null){
            login.setPassword(null);    //剔除敏感信息
            login.setNumberID(null);
        }
        return login;
    }

    @PostMapping("/alertPW")    //修改密码
    public Boolean alertPW(@RequestBody PasswordUpdateDTO users){
        return playerInfoService.alertPW(users);
    }


}
