package com.sbitech.service;

import com.sbitech.entity.Referee;

public interface RefereeService {
    Referee login(Referee referee);
    Referee findByUsername(String username);
}