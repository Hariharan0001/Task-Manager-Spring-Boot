package com.example.user.events;

import com.example.user.DTO.userResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventProducer {

    private static final String TOPIC = "user-events";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishUserUpdatedEvent(userResponseDTO event) {
        kafkaTemplate.send(TOPIC, event.getUserId().toString(), event);
    }
}
