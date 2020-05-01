package com.karaya.kafka.controller;

import com.karaya.kafka.messaging.Producer;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

// Kafka Controller Basic Info
@Api(value = "KafkaController", tags = {"Kafka Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "Kafka Controller", description = "Kafka Demo Controller")
})

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    /* Publish the Message to Kafka Topic */
    @ApiOperation(value = "Publish the Message to Kafka Topic", tags = "Universal Operations")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message Posted"),
            @ApiResponse(code = 401, message = "User Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "404 Not Found")
    })

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
}
