package com.example.TaskManager.cache;

import com.example.TaskManager.clientDTO.userResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class userCacheService {

    private static final String USER_KEY_PREFIX = "user:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public userResponse getUser(Long userId) {
        return (userResponse) redisTemplate.opsForValue()
                .get(USER_KEY_PREFIX + userId);
    }

    public void saveUser(Long userId, userResponse user) {
        redisTemplate.opsForValue()
                .set(USER_KEY_PREFIX + userId, user);
    }
}
