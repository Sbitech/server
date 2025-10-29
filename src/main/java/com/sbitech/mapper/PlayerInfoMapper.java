package com.sbitech.mapper;

import com.sbitech.dto.PasswordUpdateDTO;
import com.sbitech.entity.PlayerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PlayerInfoMapper {

    List<PlayerInfo> getUsers();

    PlayerInfo isExist(String username, String password);

    Boolean alertPW(PasswordUpdateDTO passwordUpdateDTO);
}
