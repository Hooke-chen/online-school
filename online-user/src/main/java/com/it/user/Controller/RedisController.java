package com.it.user.Controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 16622
 * \* Date: 2022/8/5
 * \* Time: 10:54
 * \* Description:
 * \
 */
@RestController
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/testRedis")
    public String getRedis(){
        redisTemplate.opsForValue().set("name","czw");
        String name = (String)redisTemplate.opsForValue().get("name");
        return name;
    }
}