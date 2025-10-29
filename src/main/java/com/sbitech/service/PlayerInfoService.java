package com.sbitech.service;

import com.sbitech.dto.PasswordUpdateDTO;
import com.sbitech.entity.PlayerInfo;

import java.util.List;

public interface PlayerInfoService {

    List<PlayerInfo> getUsers();

    PlayerInfo login(PlayerInfo user);

    Boolean alertPW(PasswordUpdateDTO users);   //修改密码
}
