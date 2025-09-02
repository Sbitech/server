package com.sbitech.service.impl;

import com.sbitech.entity.Referee;
import com.sbitech.mapper.RefereeMapper;
import com.sbitech.service.RefereeService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefereeServiceImpl implements RefereeService {

    @Autowired
    private RefereeMapper refereeMapper;


    @Override
    public Referee login(Referee referee) {
        val username = referee.getUsername();
        val password = referee.getPassword();
        return refereeMapper.exist(username, password);

    }
}
