package lin.productor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Productor1_HelloWorld {
    /**
     * simple model: one Productor one Consumer
     * @param args
     * @throws IOException
     * @throws TimeoutException
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
        // 5. create queue
        /**
         * 参数
         * String queue, 队列名
         * boolean durable, 是否持久化
         * boolean exclusive, 1.是否独占（只能有一个消费者监听队列称）；2.当connection关闭时是否删除队列
         * boolean autoDelete, 是否自动删除，当没有consumer时，自动删除
         * Map<String, Object> arguments
         */
        channel.queueDeclare("hello_world", true, false, false, null);
        // 如果没有指定队列，则自动创建
        // 6. send message to queue
        /**
         * void basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
         * 参数：
         * 1.exchange:交换机名称，当前是简单模式，交换机使用默认的""
         * 2.routingKey: 路由名称,在简单模式下，要和队列的名称一样"hello_world"
         * 3.props:配置信息
         * 4.body:字节数组，发送的消息数据
         */
        String body = "hello,rabbitmq";
        channel.basicPublish("","hello_world", null, body.getBytes());

        // 7. release resource
        channel.close();
        connection.close();
    }
}
