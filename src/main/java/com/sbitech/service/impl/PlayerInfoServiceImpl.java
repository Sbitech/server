package com.sbitech.service.impl;


import com.sbitech.dto.PasswordUpdateDTO;
import com.sbitech.entity.PlayerInfo;
import com.sbitech.mapper.PlayerInfoMapper;
import com.sbitech.service.PlayerInfoService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerInfoServiceImpl implements PlayerInfoService {
    @Autowired
    private PlayerInfoMapper playerInfoMapper;

    @Override
    public List<PlayerInfo> getUsers() {
        return playerInfoMapper.getUsers();
    }

    @Override
    public PlayerInfo login(PlayerInfo user) {
        System.out.println(user);
        String username = user.getUsername();
        String password = user.getPassword();
        return playerInfoMapper.isExist(username, password);
    }

    @Override
    public Boolean alertPW(PasswordUpdateDTO users) {
        val exist = playerInfoMapper.isExist(users.getUsername(), users.getOldPassword());
        if (exist == null) {
            return false;
        } else {
            return playerInfoMapper.alertPW(users);
        }
    }

}
