package com.sbitech.service.impl;


import com.sbitech.dto.PasswordUpdateDTO;
import com.sbitech.entity.PlayerInfo;
import com.sbitech.mapper.PlayerInfoMapper;
import com.sbitech.service.PlayerInfoService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlayerInfoServiceImpl implements PlayerInfoService {

    private final PlayerInfoMapper playerInfoMapper;

    public final List<PlayerInfo> getUsers() {
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
