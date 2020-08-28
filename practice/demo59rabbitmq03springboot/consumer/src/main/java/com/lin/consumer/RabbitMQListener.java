package com.lin.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "boot_queue")
    public void listenerQueue(Message message) {
        System.out.println(message);
        System.out.println(new String(message.getBody()));
    }
}
