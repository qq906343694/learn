package com.springboot.activeMQ.service;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMqProducerService {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue thirdPushQueue;

	@Autowired
	private Queue iosPushQueue;

	@Autowired
	private Queue huaweiPushQueue;

	@Autowired
	private Queue xiaomiPushQueue;

	@Autowired
	private Queue getuiPushQueue;

	public void sendMqThirdPush(String msg) {

		this.jmsMessagingTemplate.convertAndSend(this.thirdPushQueue, msg);
	}

	public void sendMqIosPush(String msg) {

		this.jmsMessagingTemplate.convertAndSend(this.iosPushQueue, msg);
	}

	public void sendMqHuaweiPush(String msg) {

		this.jmsMessagingTemplate.convertAndSend(this.huaweiPushQueue, msg);
	}

	public void sendMqXiaomiPush(String msg) {

		this.jmsMessagingTemplate.convertAndSend(this.xiaomiPushQueue, msg);
	}

	public void sendMqGetuiPush(String msg) {
		// 发送一个消息队列
		this.jmsMessagingTemplate.convertAndSend(this.getuiPushQueue, msg);
	}

	public void delaySend(String text, String queueName, Long time) { //
		// 获取连接工厂
		ConnectionFactory connectionFactory = this.jmsMessagingTemplate.getConnectionFactory();
		try { // 获取连接
			Connection connection = connectionFactory.createConnection();
			connection.start(); // 获取session
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); //
			// 创建一个消息队列
			Destination destination = session.createQueue(queueName);
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			TextMessage message = session.createTextMessage(text); // 设置延迟时间
			message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, time);
			// 发送
			producer.send(message);
			session.commit();
			producer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
