package com.lin.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Consumer ACK 机制：
 * 1. 设置手动签收 acknowledge="manual"
 * 2. 让监听器类实现ChannelAwareMessageListener接口
 * 3. 如果消息成功处理，则调用channel的basicAck()签收
 * 4. 如果消息处理失败，则调用channel的basicNack（）拒绝签收，broker重新发送给consumer
 */
@Component
public class Listener01Ack implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception{
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 1.接收转换消息
            System.out.println(new String(message.getBody()));
            // 2. 处理业务逻辑
            System.out.println("处理业务逻辑。");
            // 3. 手动签收
            channel.basicAck(deliveryTag,true);
        } catch (IOException e) {
            // e.printStackTrace();
            // 4. 拒绝签收
            // 参数multiple：true 允许多条消息
            // 参数requeue：重回队列，如果为true则消息重新回到queue中，broker会重新发送该消息给消费端
            channel.basicNack(deliveryTag,true,true);
        }
    }
}
