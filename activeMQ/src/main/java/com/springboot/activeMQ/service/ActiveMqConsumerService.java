package com.springboot.activeMQ.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.springboot.activeMQ.entity.QueueDefination;

@Service
public class ActiveMqConsumerService {

	private final Log logger = LogFactory.getLog(getClass());

	@JmsListener(destination = QueueDefination.THIRD_PUSH_QUEUE, concurrency = "5-10")
	public void receivethirdPushQueue(String text) {

		logger.info("third-push-begin:" + text);
		logger.info("third-push-end:" + text);

	}

	@JmsListener(destination = QueueDefination.IOS_PUSH_QUEUE, concurrency = "5-10")
	public void receiveIosPushQueue(String text) {

		logger.info("ios-push-begin:" + text);
		logger.info("ios-push-end:" + text);

	}

	@JmsListener(destination = QueueDefination.HUAWEI_PUSH_QUEUE, concurrency = "5-10")
	public void receiveHuaweiPushQueue(String text) {

		logger.info("huawei-push-begin:" + text);
		logger.info("huawei-push-end:" + text);

	}

	@JmsListener(destination = QueueDefination.XIAOMI_PUSH_QUEUE)
	public void receiveXiaomiPushQueue(String text) {

		logger.info("xiaomi-push-begin:" + text);
		logger.info("xiaomi-push-end:" + text);

	}

	@JmsListener(destination = QueueDefination.GRTUI_PUSH_QUEUE, concurrency = "5-10")
	public void receiveGetuiPush(String text) {

		logger.info("getui-push-begin:" + text);
		logger.info("getui-push-end:" + text);

	}

	@JmsListener(destination = "delay-push", concurrency = "5-10")
	public void receiveDelayQueuePush(String text) {

		logger.info("delay-push-begin:" + text);
		logger.info("delay-push-end:" + text);

	}

}
