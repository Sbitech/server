package com.sbitech.service.impl;

import com.sbitech.entity.Referee;
import com.sbitech.mapper.RefereeMapper;
import com.sbitech.service.RefereeService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RefereeServiceImpl implements RefereeService {

    @Autowired
    private RefereeMapper refereeMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Referee login(Referee referee) {
        val username = referee.getUsername();
        val password = referee.getPassword();

        // 先根据用户名查找裁判
        Referee existingReferee = refereeMapper.selectByUsername(username);
        if (existingReferee != null && passwordEncoder.matches(password, existingReferee.getPassword())) {
            return existingReferee;
        }
        return null;
    }

    @Override
    public Referee findByUsername(String username) {    //通过用户名查找裁判
        return refereeMapper.selectByUsername(username);
    }
}