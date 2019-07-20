package com.hcl.msa.integration;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
public class MSAMessageProducer {
	/**
	 * @param args Ex. "D:\\sampleapplications\\Spring3HibernateApp"
	 * @throws JMSException
	 */
	public static void main(String[] args) throws JMSException {
		
		try {
	          ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	          Connection connection = connectionFactory.createConnection(); 
	            connection.start();
	            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	            Destination destination = session.createQueue("msa.reqeust.queue");
	            MessageProducer producer = session.createProducer(destination);
	            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
	            String text = args[0]; 
	            
	            TextMessage message = session.createTextMessage(text);
	            System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
	            producer.send(message);
	            session.close();
	            connection.close();
	        } catch (Exception e) {
	            System.out.println("Caught: " + e);
	            e.printStackTrace();
	        }
	}

}
