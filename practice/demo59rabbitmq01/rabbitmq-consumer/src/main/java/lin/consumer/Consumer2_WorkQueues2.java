package lin.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2_WorkQueues2 {
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

    // 5. create queue
        /**
         * 参数
         * String queue, 队列名
         * boolean durable, 是否持久化
         * boolean exclusive, 1.是否独占（只能有一个消费者监听队列称）；2.当connection关闭时是否删除队列
         * boolean autoDelete, 是否自动删除，当没有consumer时，自动删除
         * Map<String, Object> arguments
         */
        channel.queueDeclare("work_queues", true, false, false, null);
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
            }
        };
        channel.basicConsume("work_queues", true, consumer);

        // 消费者不要关闭资源
    }
}
