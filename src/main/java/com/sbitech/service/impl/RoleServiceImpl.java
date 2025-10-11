package com.sbitech.service.impl;

import com.sbitech.entity.Role;
import com.sbitech.mapper.RoleMapper;
import com.sbitech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(Long roleId) {
        return roleMapper.getRoleById(roleId);
    }
}
