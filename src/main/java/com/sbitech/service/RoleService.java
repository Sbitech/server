package com.sbitech.service;

import com.sbitech.entity.Role;
import org.springframework.stereotype.Service;

public interface RoleService {
    Role getRoleById(Long roleId);
}
