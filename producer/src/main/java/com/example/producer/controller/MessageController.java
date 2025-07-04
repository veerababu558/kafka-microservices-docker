package com.example.producer.controller;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publish")
public class MessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/{message}")
    public String sendMessage(@PathVariable String message) {
        kafkaTemplate.send("demo-topic", message);
        return "Message sent: " + message;
    }
}
