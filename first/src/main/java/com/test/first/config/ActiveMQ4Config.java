
package com.test.first.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class ActiveMQ4Config
{
	//
	// @Autowired
	// AppConfig appConfig;
	//
	// @Bean
	// public Queue thirdPushQueue() {
	// return new ActiveMQQueue(QueueDefination.THIRD_PUSH_QUEUE);
	// }
	//
	// @Bean
	// public Queue iosPushQueue() {
	// return new ActiveMQQueue(QueueDefination.IOS_PUSH_QUEUE);
	// }
	//
	// @Bean
	// public Queue huaweiPushQueue() {
	// return new ActiveMQQueue(QueueDefination.HUAWEI_PUSH_QUEUE);
	// }
	//
	// @Bean
	// public Queue xiaomiPushQueue() {
	// return new ActiveMQQueue(QueueDefination.XIAOMI_PUSH_QUEUE);
	// }
	//
	// @Bean
	// public Queue getuiPushQueue() {
	// return new ActiveMQQueue(QueueDefination.GRTUI_PUSH_QUEUE);
	// }
	//
	// @Bean
	// public Queue baiduPushQueue() {
	// return new ActiveMQQueue(QueueDefination.BAIDU_PUSH_QUEUE);
	// }
	//
	// @Bean
	// public Queue noticePush2AppQueue() {
	// return new ActiveMQQueue(QueueDefination.NOTICE_PUSH_APP_QUEUE);
	// }
	//
	// @Bean
	// public Queue publicDetailPushQueue() { //公众号
	// return new ActiveMQQueue(QueueDefination.PUBLIC_DETAIL_PUSH_QUEUE);
	// }
	//
	// //
	// @Bean
	// public Queue offlinePassword() { //离线密码
	// return new ActiveMQQueue(QueueDefination.OFFLINE_PASSWORD_QUEUE);
	// }
	//
	// @Bean
	// public ActiveMQConnectionFactory activeMQConnectionFactory() {
	//
	// boolean bool = appConfig.isSpringActivemqIsOpen();
	//
	// //boolean bool = true;
	// if(bool){
	// ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
	// appConfig.getSpringActivemqUser(), appConfig.getSpringActivemqPassword(),
	// appConfig.getSpringActivemqBrokerUrl());
	// // "tcp://192.168.1.168:61616");
	// // ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
	// activeMQConnectionFactory.setMaxThreadPoolSize(10);
	// return activeMQConnectionFactory;
	// }
	// return new ActiveMQConnectionFactory();
	// }
	
}
