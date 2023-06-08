package com.teamextension.quickamqp;
 
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
 
public class Consumer {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
        System.out.println(amqpTemplate.receiveAndConvert("helloworld.queue"));
    }
}