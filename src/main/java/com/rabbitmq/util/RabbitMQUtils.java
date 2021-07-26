package com.rabbitmq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQUtils {

    public static Connection getConnection(){
        try {
            ConnectionFactory factory=new ConnectionFactory();
            factory.setHost("127.0.0.1");
            factory.setPort(5672);
            factory.setVirtualHost("/");
            factory.setUsername("guest");
            factory.setPassword("guest");
            return factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectionAndChannel(Channel channel,Connection connection){
        try {
            if (channel!=null) {
                channel.close();
            }
            if (connection!=null) {
                connection.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
