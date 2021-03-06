package com.xuecheng.test.rabbitmq;

import com.xuecheng.test.rabbitmq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer01_topics_springboot {

    @Autowired
    RabbitTemplate rabbitTemplate;
    // 使用RabbitTemplate 发送消息
    @Test
    public void testSendEmailMessage() {
        /**
         * 参数:
         * 1.交换机名称
         */
    }
}
