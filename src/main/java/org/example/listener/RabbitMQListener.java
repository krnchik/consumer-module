package org.example.listener;

public interface RabbitMQListener {
    void error(String str);
    void alert(String str);
    void daily(String str);
}
