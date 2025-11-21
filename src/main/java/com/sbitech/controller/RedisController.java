package com.sbitech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public Object test() {
        stringRedisTemplate.opsForValue().set("key", "value", Duration.ofSeconds(30));
        return "test";
    }

    @GetMapping("/getTime")
    public Object getTime() {
        Long key = stringRedisTemplate.getExpire("key");
        return key;
    }


}
