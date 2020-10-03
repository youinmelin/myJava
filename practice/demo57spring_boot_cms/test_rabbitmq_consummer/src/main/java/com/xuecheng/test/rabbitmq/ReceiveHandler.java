package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.xuecheng.test.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveHandler {

    /**
     * 利用@RabbitListener注解获取消息
     * @param messageStr 已经转换成String的消息内容
     * @param message 消息对象
     * @param channel 获取通道
     */
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void send_email(String messageStr, Message message, Channel channel) {
        System.out.println("received message : " + messageStr);
    }
}
