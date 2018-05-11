package com.springboot.rabbitmq.service;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.rabbitmq.entity.RabbitmqConstant;

@Component
@RabbitListener(queues = RabbitmqConstant.MQ.RECEIVE_PHOTO_PRINT_DELAY_MQ)
public class RetryPhotoPrintRabbitmqListener {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@RabbitHandler
	public void process(String cmd) {
		System.out.println("receive  " + cmd + (new Date()));

	}
}
