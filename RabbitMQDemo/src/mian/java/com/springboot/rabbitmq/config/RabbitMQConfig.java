package com.springboot.rabbitmq.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.rabbitmq.entity.RabbitmqConstant;

//@Configuration
//public class RabbitMQConfig {
//
//	@Bean
//	public Queue Queue() {
//		return new Queue("hello");
//	}
//
//}
@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.host}")
	private String rabbitmqHost;

	@Value("${spring.rabbitmq.port}")
	private int rabbitmqPort;

	@Value("${spring.rabbitmq.username}")
	private String rabbitmqUsername;

	@Value("${spring.rabbitmq.password}")
	private String rabbitmqPassword;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitmqHost, rabbitmqPort);
		connectionFactory.setUsername(rabbitmqUsername);
		connectionFactory.setPassword(rabbitmqPassword);
		connectionFactory.setVirtualHost("/");
		connectionFactory.setPublisherConfirms(true);
		return connectionFactory;
	}

	@Bean
	public DirectExchange YJExchange() {
		return new DirectExchange(RabbitmqConstant.Exchange, true, false);
	}

	// 相片打印重试队列
	@Bean
	public Queue receivePhotoPrintDelayQueue() {
		Queue queue = new Queue(RabbitmqConstant.MQ.RECEIVE_PHOTO_PRINT_DELAY_MQ, true, false, false);
		return queue;
	}

	@Bean
	public Binding receivePhotoPrintDelayQueueBinding() {
		return BindingBuilder.bind(receivePhotoPrintDelayQueue()).to(YJExchange())
				.with(RabbitmqConstant.MQ.RECEIVE_PHOTO_PRINT_DELAY_MQ);
	}

	@Bean
	public Queue sendPhotoPrintDLQueue() {
		Map<String, Object> arguments = new HashMap<>(2);
		arguments.put("x-dead-letter-exchange", RabbitmqConstant.Exchange);
		arguments.put("x-dead-letter-routing-key", RabbitmqConstant.MQ.RECEIVE_PHOTO_PRINT_DELAY_MQ);
		Queue queue = new Queue(RabbitmqConstant.MQ.SEND_PHOTO_PRINT_DL_MQ, true, false, false, arguments);
		return queue;
	}

	@Bean
	public Binding sendPhotoPrintDLQueueBinding() {
		return BindingBuilder.bind(sendPhotoPrintDLQueue()).to(YJExchange())
				.with(RabbitmqConstant.MQ.SEND_PHOTO_PRINT_DL_MQ);
	}

	// 文档打印重试队列
	@Bean
	public Queue receiveDocPrintDelayQueue() {
		Queue queue = new Queue(RabbitmqConstant.MQ.RECEIVE_DOC_PRINT_DELAY_MQ, true, false, false);
		return queue;
	}

	@Bean
	public Binding receiveDocPrintDelayQueueBinding() {
		return BindingBuilder.bind(receiveDocPrintDelayQueue()).to(YJExchange())
				.with(RabbitmqConstant.MQ.RECEIVE_DOC_PRINT_DELAY_MQ);
	}

	@Bean
	public Queue sendDocPrintDLQueue() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", RabbitmqConstant.Exchange);
		arguments.put("x-dead-letter-routing-key", RabbitmqConstant.MQ.RECEIVE_DOC_PRINT_DELAY_MQ);
		Queue queue = new Queue(RabbitmqConstant.MQ.SEND_DOC_PRINT_DL_MQ, true, false, false, arguments);
		return queue;
	}

	@Bean
	public Binding sendDocPrintDLQueueBinding() {
		return BindingBuilder.bind(sendDocPrintDLQueue()).to(YJExchange())
				.with(RabbitmqConstant.MQ.SEND_DOC_PRINT_DL_MQ);
	}

	// 广告重试队列
	@Bean
	public Queue receiveAdDelayQueue() {
		Queue queue = new Queue(RabbitmqConstant.MQ.RECEIVE_OFFLINE_AD_DELAY_MQ, true, false, false);
		return queue;
	}

	@Bean
	public Binding receiveAdDelayQueueBinding() {
		return BindingBuilder.bind(receiveAdDelayQueue()).to(YJExchange())
				.with(RabbitmqConstant.MQ.RECEIVE_OFFLINE_AD_DELAY_MQ);
	}

	@Bean
	public Queue sendAdDLQueue() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", RabbitmqConstant.Exchange);
		arguments.put("x-dead-letter-routing-key", RabbitmqConstant.MQ.RECEIVE_OFFLINE_AD_DELAY_MQ);
		Queue queue = new Queue(RabbitmqConstant.MQ.SEND_OFFLINE_AD_DL_MQ, true, false, false, arguments);
		return queue;
	}

	@Bean
	public Binding sendAdDLQueueBinding() {
		return BindingBuilder.bind(sendAdDLQueue()).to(YJExchange()).with(RabbitmqConstant.MQ.SEND_OFFLINE_AD_DL_MQ);
	}

	// 七牛处理完文档通知队列
	@Bean
	public Queue docHandleQueue() {
		Queue queue = new Queue(RabbitmqConstant.MQ.DOC_UPLOAD_7NIU_FINISH_MQ, true);
		return queue;
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(docHandleQueue()).to(YJExchange())
				.with(RabbitmqConstant.MQ.DOC_UPLOAD_7NIU_FINISH_MQ);
	}
}