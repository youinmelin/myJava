package com.lin.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Qos: 服务质量保证
 * Consumer 限流机制：
 * 1. 确保ack（签收）机制为手动确认
 * 2. 在xml中的listener-container配置属性,
 *          perfetch = n 表示消费端每次从mq中拉取n条消息，直到手动确认消费完毕后，才去拉取下一条消息
 */
@Component
public class Listener02Qos implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception{
        // 1. get message
        System.out.println(new String(message.getBody()));
        // 2. 处理业务逻辑
        // 3. 签收(手动确认）
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        Thread.sleep(1000);

    }
}
