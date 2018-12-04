package homework;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class QueueConsumer {
//	private static final Logger logger = LoggerFactory.getLogger(QueueConsumer.class);
	public static void main(String[] args) throws JMSException {
		//同步消费
/*		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.20.81.118:61616");
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("test-queue");
			MessageConsumer consumer = session.createConsumer(queue);
			while(true){
				Message message = consumer.receive(100000);
				if (null != message) {
					TextMessage textMessage = (TextMessage) message;
					System.out.println(textMessage.getText());
				} else {
					break;
				}
			}
			consumer.close();
			session.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
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
	//异步消费
	@Test
	public void testQueueComsumer() throws Exception{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.20.81.118:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("test-queue");
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
					try {
						TextMessage textMessage = (TextMessage) message;
						System.out.println(textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
			}
		});
		System.in.read();
		consumer.close();
		session.close();
		connection.close();
		
	}
	@Test
	public void testTopicConsumer() throws JMSException, IOException{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.20.81.118:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("test-topic");
//		Queue queue = session.createQueue("test-queue");
		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					System.out.println(textMessage.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		while(true) {
//			Message message = consumer.receive(10000);
//			if (null != message) {
//				try {
//					TextMessage textMessage = (TextMessage) message;
//					System.out.println(textMessage.getText());
//				} catch (JMSException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		System.in.read();
		consumer.close();
		session.close();
		connection.close();
	}
	
}
