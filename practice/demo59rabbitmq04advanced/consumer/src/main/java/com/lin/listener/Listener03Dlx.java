package com.lin.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 */
@Component
public class Listener03Dlx implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception{
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 1.接收转换消息
            System.out.println(new String(message.getBody()));
            // 2. 处理业务逻辑
            System.out.println("处理业务逻辑。");
            int i = 5/0;
            // 3. 手动签收
            channel.basicAck(deliveryTag,true);
        } catch (Exception e) {
             e.printStackTrace();
            System.out.println("出现异常，拒绝接收消息");
            // 4. 拒绝签收,不重回队列 requeue = false
            // 参数multiple：true 允许多条消息
            // 参数requeue：重回队列，如果为true则消息重新回到queue中，broker会重新发送该消息给消费端
            channel.basicNack(deliveryTag,true,false);
        }
    }
}
