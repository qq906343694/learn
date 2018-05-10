package com.springboot.activeMQ.entity;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class ActiveMQFlag {

	@Bean
	public Queue thirdPushQueue() {

		return new ActiveMQQueue(QueueDefination.THIRD_PUSH_QUEUE);
	}

	@Bean
	public Queue iosPushQueue() {

		return new ActiveMQQueue(QueueDefination.IOS_PUSH_QUEUE);
	}

	@Bean
	public Queue huaweiPushQueue() {

		return new ActiveMQQueue(QueueDefination.HUAWEI_PUSH_QUEUE);
	}

	@Bean
	public Queue xiaomiPushQueue() {

		return new ActiveMQQueue(QueueDefination.XIAOMI_PUSH_QUEUE);
	}

	@Bean
	public Queue getuiPushQueue() {

		return new ActiveMQQueue(QueueDefination.GRTUI_PUSH_QUEUE);
	}

	@Bean
	public Queue baiduPushQueue() {

		return new ActiveMQQueue(QueueDefination.BAIDU_PUSH_QUEUE);
	}

	@Bean
	public Queue noticePush2AppQueue() {

		return new ActiveMQQueue(QueueDefination.NOTICE_PUSH_APP_QUEUE);
	}

	@Bean
	public Queue publicDetailPushQueue() { // 公众号

		return new ActiveMQQueue(QueueDefination.PUBLIC_DETAIL_PUSH_QUEUE);
	}

	//
	@Bean
	public Queue offlinePassword() { // 离线密码

		return new ActiveMQQueue(QueueDefination.OFFLINE_PASSWORD_QUEUE);
	}

	// JPush给ISO用
	@Bean
	public Queue jPushQueue() {

		return new ActiveMQQueue(QueueDefination.JPUSH_PUSH_QUEUE);
	}
}
