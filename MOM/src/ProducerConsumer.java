import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

// Producer class to send messages
class Producer {
    private static String url = "failover:tcp://localhost:61616";
    private static String subject = "TESTQUEUE1";

    public void sendMessages() throws JMSException {
        ConnectionFactory connectionFactory = (ConnectionFactory) new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(subject);
        MessageProducer producer = session.createProducer(destination);

        try {
            int msgTemp = 0;
            while (msgTemp < 10) { // Gửi 10 tin nhắn
                msgTemp++;
                String msg = "TextMessage-" + String.valueOf(msgTemp);
                TextMessage message = session.createTextMessage(msg);
                producer.send(message);
                System.out.println("Producer sent: " + msg);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer Error: " + e.getMessage());
        } finally {
            producer.close();
            session.close();
            connection.close();
        }
    }
}

// Consumer class to receive messages
class Consumer {
    private static String url = "failover:tcp://localhost:61616";
    private static String subject = "TESTQUEUE1";

    public void receiveMessages() throws JMSException {
        ConnectionFactory connectionFactory = (ConnectionFactory) new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(subject);
        MessageConsumer consumer = session.createConsumer(destination);

        System.out.println("Consumer waiting for messages...");
        try {
            while (true) {
                TextMessage message = (TextMessage) consumer.receive();
                if (message != null) {
                    System.out.println("Consumer received: " + message.getText());
                }
            }
        } catch (JMSException e) {
            System.out.println("Consumer Error: " + e.getMessage());
        } finally {
            consumer.close();
            session.close();
            connection.close();
        }
    }
}

// Main class to run Producer and Consumer in separate threads
public class ProducerConsumer {
    public static void main(String[] args) {
        // Run Producer in a separate thread
        new Thread(() -> {
            try {
                new Producer().sendMessages();
            } catch (JMSException e) {
                System.out.println("Main Producer Error: " + e.getMessage());
            }
        }).start();

        // Run Consumer in a separate thread
        new Thread(() -> {
            try {
                new Consumer().receiveMessages();
            } catch (JMSException e) {
                System.out.println("Main Consumer Error: " + e.getMessage());
            }
        }).start();
    }
}