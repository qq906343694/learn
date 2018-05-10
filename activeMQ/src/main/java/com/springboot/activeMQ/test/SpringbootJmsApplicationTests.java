package com.springboot.activeMQ.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJmsApplicationTests {

	@Autowired
	private ActiveMqProducerService producer;

	@Test
	public void contextLoads() {
		for (int i = 0; i < 20; i++) {
			producer.sendMqGetuiPush("发送小米推送队列" + i);
			long time = 10 * 6000;
			producer.delaySend("delay-push" + i, "delay-push", time);
		}
	}

}