package com.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();

        channel.queueDeclare("hello",false,false,false,null);
        channel.basicPublish("","hello",null,"hello rabbitmq".getBytes());
        channel.close();
        connection.close();
    }
}
