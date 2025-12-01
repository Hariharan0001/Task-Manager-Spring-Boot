package com.example.TaskManager.events;

import com.example.TaskManager.clientDTO.userResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import com.example.TaskManager.cache.userCacheService;
import org.springframework.stereotype.Service;

@Service
public class UserEventConsumer {

    @Autowired
    private userCacheService userCacheService;

    @KafkaListener(topics = "user-events", groupId = "task-service-group")
    public void consume(userResponse event) {

        userResponse user = new userResponse(
                event.getUserId(),
                event.getUsername(),
                event.getEmail()
        );

        // ✅ Update Redis cache
        userCacheService.saveUser(event.getUserId(), user);
    }
}
