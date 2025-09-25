package com.sbitech.controller;

import com.sbitech.entity.Referee;
import com.sbitech.service.RefereeService;
import com.sbitech.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        Referee login = refereeService.login(referee);
        if (login != null) {
            // 生成JWT令牌
            String token = jwtUtil.generateToken(login.getUsername(), login.getRole().toString());
            System.err.println("Generated Token: " + token);
            // 创建响应数据
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("referee", login);

            // 剔除敏感信息
            login.setPassword(null);
            login.setPhone(null);

            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body("登录失败：用户名或密码错误");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            if (jwtUtil.validateToken(jwt)) {
                String username = jwtUtil.getUsernameFromToken(jwt);
                Referee referee = refereeService.findByUsername(username);
                if (referee != null) {
                    referee.setPassword(null);
                    referee.setPhone(null);
                    return ResponseEntity.ok(referee);
                }
            }
        }
        return ResponseEntity.badRequest().body("无效的令牌");
    }
}