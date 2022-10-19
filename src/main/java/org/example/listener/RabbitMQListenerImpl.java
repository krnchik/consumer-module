package org.example.listener;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitMQListenerImpl implements RabbitMQListener {

    @RabbitListener(queues = "error_queue")
    public void error(String str) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Message message = objectMapper.readValue(str, Message.class);
            System.out.println("ERROR: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RabbitListener(queues = "daily_queue")
    public void daily(String str) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Message message = objectMapper.readValue(str, Message.class);
            System.out.println("DAILY: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "alert_queue")
    public void alert(String str) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Message message = objectMapper.readValue(str, Message.class);
            System.out.println("ALERT: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
