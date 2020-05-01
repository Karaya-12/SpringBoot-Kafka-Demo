package com.karaya.kafka.messaging;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class Producer {

    private static final String TOPIC = "testDemo";  // Send Messages to a Topic named 'testDemo'
    private final KafkaTemplate<String, String> kafkaTemplate;  // Spring's KafkaTemplate

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        this.kafkaTemplate.send(TOPIC, message);
        log.info(String.format("$$ -> Produced Message --> %s", message));
    }
}
