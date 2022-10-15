package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "error_queue")
    public void error(String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Message message = objectMapper.readValue(str, Message.class);
        System.out.println("ERROR: " + message);
    }

    @RabbitListener(queues = "daily_queue")
    public void daily(String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Message message = objectMapper.readValue(str, Message.class);
        System.out.println("DAILY: " + message);
    }

    @RabbitListener(queues = "alert_queue")
    public void alert(String str) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Message message = objectMapper.readValue(str, Message.class);
        System.out.println("ALERT: " + message);
    }
}
