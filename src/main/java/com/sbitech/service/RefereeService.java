package com.sbitech.service;

import com.sbitech.entity.Referee;

public interface RefereeService {
    Referee login(Referee referee);
    Referee findByUsername(String username);
    
    /**
     * 根据用户名查询裁判信息，包含角色和权限信息
     * @param username 用户名
     * @return 裁判信息（包含角色和权限）
     */
    Referee findByUsernameWithPermissions(String username);
}