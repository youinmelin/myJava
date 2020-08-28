package lin.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer5_Topic1 {
    /*
    two consumer: workqueue1 and workqueue2 will receive all messages one by one from productor
     */
    public static void main(String[] args) throws IOException, TimeoutException {

        // 1. build connection factory
        ConnectionFactory factory = new ConnectionFactory();
        // 2. config

        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 3. create connection
        Connection connection = factory.newConnection();
        // 4. create channel
        Channel channel = connection.createChannel();

        String queue1Name = "test_topic_queue1";
        String queue2Name = "test_topic_queue2";
        // 如果没有指定队列，则自动创建ic static void main(String[] args) {

        //6. receive message
        /**
         * public String basicConsume(String queue, boolean autoAck, Consumer callback)
         * arguments:
         *  1. queue: queue name
         *  2. autoACk: 是否自动确认，回复收到消息与否
         *  3. callback: 回调对象，自动执行自定义方法
         */
        Consumer consumer = new DefaultConsumer(channel) {
            /*
            回调方法：收到消息后，会自动执行该方法
            1. consummerTag:消息标识
            2. envelope：获取信息，交换机，路由key等
            3. properties：配置信息
            4. body：数据
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println("consumerTag:" + consumerTag);
//                System.out.println("Exchange:" + envelope.getExchange());
//                System.out.println("RoutingKey:" + envelope.getRoutingKey());
//                System.out.println("properties:" + properties);
                System.out.println("body:" + new String(body));
                System.out.println("save log info into database");
            }
        };
        channel.basicConsume(queue1Name, true, consumer);

        // 消费者不要关闭资源
    }
}
