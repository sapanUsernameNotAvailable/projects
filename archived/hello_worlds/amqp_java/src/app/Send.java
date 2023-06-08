package app;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	final static String QUEUE_NAME = "hello";
	final static String message = "Hello World!";

	public static void main(String[] argv) throws Exception {
		
		// then we can create a connection to the server:
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		
		// Next we create a channel,
		Channel channel = connection.createChannel();
		
		// To send, we must declare a queue for us to send to;
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// then we can publish a message to the queue:
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

		System.out.println(" [x] Sent '" + message + "'");
		channel.close();
		connection.close();
	}
}