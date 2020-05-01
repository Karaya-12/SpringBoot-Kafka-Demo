package com.karaya.kafka.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @KafkaListener(topics = {"testDemo"}, groupId = "KafkaDemo")
    public void consume(String message) {
        log.info(String.format("$$ -> Consumed Message -> %s", message));
    }
}
