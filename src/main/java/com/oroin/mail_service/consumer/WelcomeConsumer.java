package com.oroin.mail_service.consumer;

import com.oroin.mail_service.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WelcomeConsumer {

    @Value("${current.env}")
    private String currentEnv;
    private static final String USER_REGISTER_FINISHED_TOPIC = "user-registered";

    @KafkaListener(topics = "dev.user-registered", groupId = "mail-service")
    public void consume(UserResponse event){
        log.info("Received user registration event: {}", event);
    }
}
