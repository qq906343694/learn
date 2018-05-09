
package com.test.first.config;

import org.springframework.context.annotation.Configuration;

/**
 * 程序配置
 * 
 * @author leoyou
 */
// @Import(FdfsClientConfig.class) //fasfdfs新加的注解
@Configuration
public class AppConfig
{
	
	// 单独配置门口机机使用的外网地址 开始
	// @Value("${mqtt.todoor.host}")
	// private String mqttToDoorHost;
	//
	// @Value("${mqtt.todoor.port}")
	// private int mqttToDoorPort;
	//
	// @Value("${mqtt.todoor.username}")
	// private String mqttToDoorUsername;
	//
	// @Value("${mqtt.todoor.password}")
	// private String mqttToDoorPassword;
	// // 单独配置门口机机使用的外网地址 结束
	//
	// @Value("${mqtt.host}")
	// private String mqttHost;
	//
	// @Value("${mqtt.port}")
	// private int mqttPort;
	//
	// @Value("${mqtt.username}")
	// private String mqttUsername;
	//
	// @Value("${mqtt.password}")
	// private String mqttPassword;
	//
	// @Value("${mqtt.client.id}")
	// private String mqttClientId;
	//
	// @Value("${security.sign.disable.phone}")
	// private boolean securitySignDisablePhone;
	//
	// @Value("${security.sign.disable.door}")
	// private boolean securitySignDisableDoor;
	//
	// @Value("${security.sign.disable.sms}")
	// private boolean securitySignDisableSms;
	//
	// @Value("${security.sign.disable.fs}")
	// private boolean securitySignDisableFs;
	//
	// @Value("${security.sign.key.phone}")
	// private String securitySignKeyPhone;
	//
	// @Value("${security.sign.key.door}")
	// private String securitySignKeyDoor;
	//
	// @Value("${security.sign.key.sms}")
	// private String securitySignKeySms;
	//
	// @Value("${security.sign.key.fs}")
	// private String securitySignKeyFs;
	//
	// @Value("${photo.photo_path}")
	// private String photoPath;
	//
	// @Value("${ad.url_head}")
	// private String adUrlHead;
	//
	// @Value("${push.url}")
	// private String pushUrl;
	//
	// @Value("${push.url.mi}")
	// private String pushUrlMi;
	//
	// @Value("${push.url.ios}")
	// private String pushUrlIos;
	//
	// @Value("${push.url.ttsq}")
	// private String pushUrlTtsq;// 天天社区包名推送地址
	//
	// @Value("${sip.server.domain}")
	// private String sipServerDomain;
	//
	// @Value("${sip.server.port}")
	// private int sipServerPort;
	//
	// @Value("${door.transport.type}")
	// private int doorTransportType;
	//
	// @Value("${app.transport.type}")
	// private int appTransportType;
	//
	// @Value("${app.login.md5.on}")
	// private boolean appLoginMd5On;
	//
	// @Value("${door.update.max.allow}")
	// private int doorUpdateMaxAllow;
	//
	// @Value("${spring.activemq.broker-url}")
	// private String springActivemqBrokerUrl;
	// @Value("${spring.activemq.user}")
	// private String springActivemqUser;
	// @Value("${spring.activemq.password}")
	// private String springActivemqPassword;
	// @Value("${spring.activemq.in-memory}")
	// private String springActivemqInMemory;
	// @Value("${spring.activemq.pool.enabled}")
	// private String springActivemqPoolEnabled;
	// @Value("${spring.activemq.isOpen}")
	// private boolean springActivemqIsOpen; // 是否加入消费者 true :是 false:否
	//
	// @Value("${cornucopia.resourcePath}")
	// private String cornucopiaResourcePath;
	// @Value("${cornucopia.pass}")
	// private int cornucopiaPass;
	// @Value("${cornucopia.about}")
	// private String cornucopiaAbout;
	// @Value("${cornucopia.url}")
	// private String cornucopiaUrl;
	//
	// @Value("${fdfs.url}")
	// private String fdfsUrl;
	//
	// @Value("${door.ad.fenbianlv}")
	// private String fenbianlv; // 门口机广告分辨率配置 20170923 add
	//
	// @Value("${app.version}")
	// private String appVersion; // appstore要审核是版本的前一个版本号
	//
	// @Value("${app.appCheck}")
	// private boolean appAppCheck; // 是否进行app版本审核
	//
	// @Value("${app.img.fenbianlv}")
	// private String appImgFenbianlv; // app朋友圈缩略图
	//
	//
	// @Value("${door.timerSwitchIsOpen}")
	// private boolean doorTimerSwitchIsOpen; // 异常门口机异常任务开关
	//
	//
	// public boolean isDoorTimerSwitchIsOpen()
	// {
	//
	// return doorTimerSwitchIsOpen;
	// }
	//
	//
	// public String getMqttHost()
	// {
	//
	// return mqttHost;
	// }
	//
	//
	// public int getMqttPort()
	// {
	//
	// return mqttPort;
	// }
	//
	//
	// public String getMqttUsername()
	// {
	//
	// return mqttUsername;
	// }
	//
	//
	// public String getMqttPassword()
	// {
	//
	// return mqttPassword;
	// }
	//
	//
	// public String getMqttClientId()
	// {
	//
	// return mqttClientId;
	// }
	//
	//
	// public boolean isSecuritySignDisablePhone()
	// {
	//
	// return securitySignDisablePhone;
	// }
	//
	//
	// public boolean isSecuritySignDisableDoor()
	// {
	//
	// return securitySignDisableDoor;
	// }
	//
	//
	// public boolean isSecuritySignDisableSms()
	// {
	//
	// return securitySignDisableSms;
	// }
	//
	//
	// public String getSecuritySignKeyPhone()
	// {
	//
	// return securitySignKeyPhone;
	// }
	//
	//
	// public String getSecuritySignKeyDoor()
	// {
	//
	// return securitySignKeyDoor;
	// }
	//
	//
	// public String getSecuritySignKeySms()
	// {
	//
	// return securitySignKeySms;
	// }
	//
	//
	// public String getPhotoPath()
	// {
	//
	// return photoPath;
	// }
	//
	//
	// public String getAdUrlHead()
	// {
	//
	// return adUrlHead;
	// }
	//
	//
	// public String getPushUrl()
	// {
	//
	// return pushUrl;
	// }
	//
	//
	// public boolean isSecuritySignDisableFs()
	// {
	//
	// return securitySignDisableFs;
	// }
	//
	//
	// public String getSecuritySignKeyFs()
	// {
	//
	// return securitySignKeyFs;
	// }
	//
	//
	// public String getSipServerDomain()
	// {
	//
	// return sipServerDomain;
	// }
	//
	//
	// public int getSipServerPort()
	// {
	//
	// return sipServerPort;
	// }
	//
	//
	// public String getPushUrlMi()
	// {
	//
	// return pushUrlMi;
	// }
	//
	//
	// public int getDoorTransportType()
	// {
	//
	// return doorTransportType;
	// }
	//
	//
	// public int getAppTransportType()
	// {
	//
	// return appTransportType;
	// }
	//
	//
	// public boolean isAppLoginMd5On()
	// {
	//
	// return appLoginMd5On;
	// }
	//
	//
	// public String getSpringActivemqBrokerUrl()
	// {
	//
	// return springActivemqBrokerUrl;
	// }
	//
	//
	// public String getSpringActivemqUser()
	// {
	//
	// return springActivemqUser;
	// }
	//
	//
	// public String getSpringActivemqPassword()
	// {
	//
	// return springActivemqPassword;
	// }
	//
	//
	// public String getSpringActivemqInMemory()
	// {
	//
	// return springActivemqInMemory;
	// }
	//
	//
	// public String getSpringActivemqPoolEnabled()
	// {
	//
	// return springActivemqPoolEnabled;
	// }
	//
	//
	// public String getPushUrlIos()
	// {
	//
	// return pushUrlIos;
	// }
	//
	//
	// public int getDoorUpdateMaxAllow()
	// {
	//
	// return doorUpdateMaxAllow;
	// }
	//
	//
	// public String getCornucopiaResourcePath()
	// {
	//
	// return cornucopiaResourcePath;
	// }
	//
	//
	// public int getCornucopiaPass()
	// {
	//
	// return cornucopiaPass;
	// }
	//
	//
	// public String getCornucopiaAbout()
	// {
	//
	// return cornucopiaAbout;
	// }
	//
	//
	// public String getCornucopiaUrl()
	// {
	//
	// return cornucopiaUrl;
	// }
	//
	//
	// public String getFdfsUrl()
	// {
	//
	// return fdfsUrl;
	// }
	//
	//
	// public String getFenbianlv()
	// {
	//
	// return fenbianlv;
	// }
	//
	//
	// public String getMqttToDoorHost()
	// {
	//
	// return mqttToDoorHost;
	// }
	//
	//
	// public int getMqttToDoorPort()
	// {
	//
	// return mqttToDoorPort;
	// }
	//
	//
	// public String getMqttToDoorUsername()
	// {
	//
	// return mqttToDoorUsername;
	// }
	//
	//
	// public String getMqttToDoorPassword()
	// {
	//
	// return mqttToDoorPassword;
	// }
	//
	//
	// public boolean isSpringActivemqIsOpen()
	// {
	//
	// return springActivemqIsOpen;
	// }
	//
	//
	// public String getPushUrlTtsq()
	// {
	//
	// return pushUrlTtsq;
	// }
	//
	//
	// public String getAppImgFenbianlv()
	// {
	//
	// return appImgFenbianlv;
	// }
	//
	//
	// public String getAppVersion()
	// {
	//
	// return appVersion;
	// }
	//
	//
	// public boolean isAppAppCheck()
	// {
	//
	// return appAppCheck;
	// }
	
	
}
