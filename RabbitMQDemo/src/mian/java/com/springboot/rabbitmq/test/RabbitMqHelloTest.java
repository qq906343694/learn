package com.springboot.rabbitmq.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.springboot.rabbitmq.entity.CmdData;
import com.springboot.rabbitmq.entity.RabbitmqConstant;
import com.springboot.rabbitmq.service.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

	@Autowired
	private HelloSender helloSender;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void hello() {
		CmdData data = new CmdData();
		data.setContent("sjijjj");
		data.setFlag("2");
		data.setTitle("1234");
		rabbitTemplate.convertAndSend(RabbitmqConstant.Exchange, RabbitmqConstant.MQ.SEND_PHOTO_PRINT_DL_MQ,
				JSON.toJSONString(data), new MessagePostProcessor() {

					@Override
					public Message postProcessMessage(Message message) throws AmqpException {
						message.getMessageProperties().setExpiration(String.valueOf(60 * 1000));
						return message;
					}
				});
		System.out.println(new Date());
	}

}
