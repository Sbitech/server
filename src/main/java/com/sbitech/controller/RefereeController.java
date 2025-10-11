package com.sbitech.controller;

import com.sbitech.entity.Permission;
import com.sbitech.entity.Referee;
import com.sbitech.service.RefereeService;
import com.sbitech.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/referee")
public class RefereeController {
    @Autowired
    private RefereeService refereeService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Referee referee) {
        // 使用现有的登录验证逻辑
        Referee login = refereeService.login(referee);
        if (login != null) {
            // 获取完整的裁判信息，包含角色和权限
            Referee refereeWithPermissions = refereeService.findByUsernameWithPermissions(login.getUsername());
            
            if (refereeWithPermissions != null) {
                // 生成JWT令牌
                String roleName = refereeWithPermissions.getRole() != null ? 
                    refereeWithPermissions.getRole().getRoleName() : "REFEREE";
                String token = jwtUtil.generateToken(refereeWithPermissions.getUsername(), roleName);
                System.err.println("Generated Token: " + token);
                
                // 创建响应数据
                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                
                // 构建用户信息，剔除敏感信息
                Map<String, Object> userInfo = new HashMap<>();
                userInfo.put("id", refereeWithPermissions.getId());
                userInfo.put("username", refereeWithPermissions.getUsername());
                userInfo.put("name", refereeWithPermissions.getName());
                userInfo.put("role", refereeWithPermissions.getRole());
                
                // 构建权限列表，只返回权限编码
                List<String> permissionCodes = new ArrayList<>();
                if (refereeWithPermissions.getPermissions() != null) {
                    for (Permission permission : refereeWithPermissions.getPermissions()) {
                        permissionCodes.add(permission.getPermissionCode());
                    }
                }
                userInfo.put("permissions", permissionCodes);
                
                response.put("userInfo", userInfo);
                
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.badRequest().body("登录失败：用户名或密码错误");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            if (jwtUtil.validateToken(jwt)) {
                String username = jwtUtil.getUsernameFromToken(jwt);
                Referee referee = refereeService.findByUsernameWithPermissions(username);
                if (referee != null) {
                    // 剔除敏感信息
                    referee.setPassword(null);
                    referee.setPhone(null);
                    return ResponseEntity.ok(referee);
                }
            }
        }
        return ResponseEntity.badRequest().body("无效的令牌");
    }
}