package com.lin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    // 1. injection RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHelloWorld() {
        // 2. send message
        rabbitTemplate.convertAndSend("spring_queue", "hello world spring......");
    }
    @Test
    public void testFanout() {
        // 2. send fanout message
        rabbitTemplate.convertAndSend("spring_fanout_exchange","", "fanout spring......");
    }
    @Test
    public void testTopics() {
        // 2. send topics message
        rabbitTemplate.convertAndSend("spring_topic_exchange","heima.hehe.haha", "topic spring......");
    }
}
