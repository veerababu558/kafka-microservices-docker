package com.example.consumer.listener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
