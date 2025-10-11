package com.sbitech.service.impl;

import com.sbitech.entity.Permission;
import com.sbitech.entity.Referee;
import com.sbitech.mapper.PermissionMapper;
import com.sbitech.mapper.RefereeMapper;
import com.sbitech.service.RefereeService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefereeServiceImpl implements RefereeService {

    @Autowired
    private RefereeMapper refereeMapper;

    @Autowired
    private PermissionMapper permissionMapper;

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
    public Referee findByUsername(String username) {
        return refereeMapper.selectByUsername(username);
    }
    
    @Override
    public Referee findByUsernameWithPermissions(String username) {
        // 查询裁判信息，包含角色信息
        Referee referee = refereeMapper.selectByUsernameWithRole(username);
        if (referee != null) {
            // 查询裁判的权限列表
            List<Permission> permissions = permissionMapper.findPermissionsByRefereeId(referee.getId());
            referee.setPermissions(permissions);
        }
        return referee;
    }
}