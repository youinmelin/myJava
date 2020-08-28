package lin.productor;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Productor4_Routing {
    /**
     * WorkQueues model: one Productor more Consumers
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

        // 5. create exchange 交换机
        String exchangeName = "test_direct";
        /**
         * public DeclareOk exchangeDeclare(String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments)
         * arguments:
         * 1.exchange: exchange name
         * 2.type: exchange type
         *          DIRECT("direct"),定向
         FANOUT("fanout"),广播（扇形），发送消息到每一个与之绑定的队列，重点
         TOPIC("topic"),通配符方式，重点
         HEADERS("headers")参数匹配
         * 3.durable:持久化
         * 4.autoDelete:自动删除
         * 5.internal:mq内部使用，false
         * 6. arguments:参数
         */
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false,false,null);
        // 6. create queues
        String queue1Name = "test_direct_queue1";
        String queue2Name = "test_direct_queue2";

        channel.queueDeclare(queue1Name, true, false, false, null);
        channel.queueDeclare(queue2Name, true, false, false, null);
        // 7. bind queues on express
        /**
         * public com.rabbitmq.client.AMQP.Queue.BindOk queueBind(String queue, String exchange, String routingKey)
         * arguments:
         * 1. queue: queue name;
         * 2. exchange: exchange name;
         * 3. routingKey: 路由键，绑定规则 如果交换机类型为fanout，routingKey设置为""
         */
        // queue1 bind error
        channel.queueBind(queue1Name, exchangeName, "error");
        // queue2 bind info,error,waining
        channel.queueBind(queue2Name, exchangeName, "info");
        channel.queueBind(queue2Name, exchangeName, "error");
        channel.queueBind(queue2Name, exchangeName, "warning");
        // 8. send message
        String body = "log info: lin called findAll method. log level:info";
        channel.basicPublish(exchangeName, "info", null, body.getBytes());

        String body2 = "log info: lin called delete method. log level: error";
        channel.basicPublish(exchangeName, "error", null, body2.getBytes());
        // 9. release resource
        channel.close();
        connection.close();
    }
}
