package com.lin.producer;

import com.lin.rabbitmq.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "boot.haha", "boot mq message...hello");
    }
}
