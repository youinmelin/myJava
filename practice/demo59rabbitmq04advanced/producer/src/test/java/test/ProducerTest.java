package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 确认模式：
     * steps:
     *  1. 配置文件中：确认模式开启publisher-confirms="true"
     *  2. 在rabbitTemplate定义ConfirmCallBack回调函数
     */
    @Test
    public void testConfirm() {

        // define callback
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            //回调函数通过匿名内部类的方式(可以通过lamda表达式简化)，当消息发送出去后，内部的方法会自动执行

            /**
             *
             * @param correlationData 配置信息
             * @param ack: (Acknowledge) exchange交换机是否成功收到消息，true false
             * @param cause 失败的原因
             */
            @Override
            public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
                System.out.println("confirm method has run.");
                if (ack) {
                    // receive message successfully
                    System.out.println("receive message successfully "+ cause);
                }else{
                    // receive message failed
                    System.out.println(" receive message failed, because:" + cause);
                    // 做一些处理，让消息再次发送
                }
            }
        });
        // send message
        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm");
    }

    /**
     * 回退模式： 当消息发送给exchange后，Exchange路由到queue失败时 才会执行ReturnCallBack
     * steps:
     *  1. 配置文件中：回退模式开启publisher-returns="true"
     *  2. 设置Exchange处理消息的模式rabbitTemplate.setMandatory(true);
     *    1）如果消息没有路由到Queue，则丢弃消息（默认）
     *    2）如果消息没有路由到Queue，返回给消息发送方ReturnCallBack
     *  3. 在rabbitTemplate定义ReturnCallBack回调函数
     */
    @Test
    public void testReturn() {
        // 设置交换机处理消息失败的模式
        rabbitTemplate.setMandatory(true);
        // set ReturnCallBack
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * @param message :message object
             * @param replyCode : error code
             * @param replyText: error text
             * @param exchange: exchange name
             * @param routingKey: runtingKey
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("return method has run...");
                System.out.println("message: " + message);
                System.out.println("replyCode: " + replyCode);
                System.out.println("replyText: " + replyText);
                System.out.println("exchange: " + exchange);
                System.out.println("routingKey: " + routingKey);
            }
        });
        // send message
        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm");
    }

    @Test
    public void testSend() {
        for (int i = 0; i < 10; i++) {
            // send message
            rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm" + i);
        }
    }

    /**
     * TTL: 过期时间
     * 1. 队列统一过期时间
     * 2. 消息单独过期时间
     *
     * 如果消息过期时间和队列过期时间都设置了，以时间短的为准
     * 如果队列过期后会将队列中所有消息移除
     * 如果消息过期后，只有消息在队列顶端才会判断是否过期，此时再被移除
     */
    @Test
    public void testTTL() {
//        for (int i = 0; i < 10; i++) {
//            // send message队列统一过期时间
//            rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.message.001", "message ttl" + i);
//        }

        // 消息的后处理对象，可以设置消息的参数信息
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 1. set message
                message.getMessageProperties().setExpiration("5000");// 消息的过期时间，毫秒
                // 2. return message
                return message;
            }
        };
        //消息单独过期时间
        rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.message.001", "message ttl", messagePostProcessor  );
    }

    /**
     * 发送测试死信消息：
     * 三种情况：
     *  1. 过期时间
     *  2.长度限制
     *  3.消息拒收
     */
    @Test
    public void testDlx() {
        // 1. 测试过期时间
//        rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.send","dxl message send...");
        // 2. 测试长度限制后，消息死信
//        for (int i = 0; i < 15; i++) {
//            rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.send","dxl message send..." + i);
//        }

        // 3. 测试消息拒收
        rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.send","dxl message send...");
        rabbitTemplate.convertAndSend("exchange_dlx", "dlx.send","dxl message send...");
    }
}
