package com.yay.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/29 15:21
 */
public class JmsDemo {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session = null;
        Destination destination;
        MessageProducer producer = null;
        MessageConsumer consumer;
        Message message;
        boolean useTransaction = false;

        try {

            Context ctx = new InitialContext();
            connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactoryName");


            //active MQ
            //connectionFactory = new ActiveMQConnectionFactory(user, password, getOptimizeBrokerUrl(broker));


            connection = connectionFactory.createConnection();

            connection.start();

            session = connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);

            destination = session.createQueue("TEST.QUEUE");

            producer = session.createProducer(destination);

            session.createTextMessage("我是小天");
            session.createTextMessage("第二次消息");


            consumer = session.createConsumer(destination);

            TextMessage receive = (TextMessage) consumer.receive(1000);

            System.out.println("Receive:" + receive);


            consumer.setMessageListener(System.out::println);


        } catch (JMSException | NamingException e) {
            e.printStackTrace();
        } finally {
            if (null != producer) {
                producer.close();
            }
            if (null != session) {
                session.close();
            }
            if (null != connection) {
                connection.close();
            }
        }

    }
}
