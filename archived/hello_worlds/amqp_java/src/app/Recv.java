package app;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

	final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {

		// then we can create a connection to the server:
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();

		// Next we create a channel,
		Channel channel = connection.createChannel();

		// To receive, we must declare a queue for us to receive from;
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		// consuming
		
		// QueueingConsumer provides a callback that will buffer the messages until we're ready to use them.
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);

		while (true) {
			String message = new String(consumer.nextDelivery().getBody());
			System.out.println(" [x] Received '" + message + "'");
		}
	}
}