package homework;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class ActiveMqTest {

	@Test
	public void textQueueProducer() throws Exception{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.20.81.118:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("test-queue");
		MessageProducer producer = session.createProducer(queue);
		TextMessage message = session.createTextMessage("hello1, this is test-queue message");
		producer.send(message);
		producer.close();
		session.close();
		connection.close();
	}
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.20.81.118:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("test_queue");
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					try {
						System.out.println(textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
//		System.in.read();
		consumer.close();
		session.close();
		connection.close();
	}
	@Test
	public void testTopicProducer() throws JMSException{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.20.81.118:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("test-topic");
		MessageProducer producer = session.createProducer(topic);
		TextMessage message = session.createTextMessage();
		message.setText("hello,this is a message of topic!");
		producer.send(message);
		
		producer.close();
		session.close();
		connection.close();
	}
	
}
