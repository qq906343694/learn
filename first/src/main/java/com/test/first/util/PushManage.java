
package com.test.first.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushManage
{
	
	private final static String appKey = "1c558743cd57cbcaf206f5ef";
	private final static String masterSecret = "9a37e714405b3f853d55fec6";
	private static Log log = LogFactory.getLog(PushManage.class);
	private final static ClientConfig clientConfig = ClientConfig.getInstance();
	private static JPushClient memberJpushClient = new JPushClient(masterSecret , appKey , null , clientConfig);
	
	
	public static void sendAllPush(String registrationId , String msgTitle , String msgContent)
	{
		
		// PushPayload payload = buildPushObject_all_all_alert(msgContent);
		PushPayload payload = buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(registrationId, msgTitle,
					msgContent);
		payload.resetOptionsApnsProduction(false);// false--开发环境，true--生产环境
		PushResult result = null;
		try
		{
			result = memberJpushClient.sendPush(payload);
			log.info("Got result - " + result);
		}
		catch (APIConnectionException e)
		{
			log.error("Connection error. Should retry later. ", e);
		}
		catch (APIRequestException e)
		{
			log.error("Error response from JPush server. Should review and fix it. ", e);
			log.info("HTTP Status: " + e.getStatus());
			log.info("Error Code: " + e.getErrorCode());
			log.info("Error Message: " + e.getErrorMessage());
			log.info("Msg ID: " + e.getMsgId());
		}
		System.out.println(result);
	}
	
	
	// public static void sendMemberPush(List<TSeUnagent> uns , JPushData jPushData)
	// {
	//
	// for (TSeUnagent tSeUnagent : uns)
	// {
	// sendMemberPush(tSeUnagent.getUnid(), jPushData.getContent());
	// }
	// }
	/**
	 * 
	 * @comment: 所有平台，所有设备，内容为 ALERT 的通知。
	 */
	// public static PushPayload buildPushObject_all_all_alert(String msgContent)
	// {
	//
	// PushPayload build = PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.all())
	// .setNotification(Notification.newBuilder()
	// .addPlatformNotification(AndroidNotification.newBuilder().setAlert(msgContent).build())
	// .addPlatformNotification(IosNotification.newBuilder().setAlert(msgContent)
	// .setSound("happy.caf").setBadge(0).build())
	// .build())
	// .build();
	// return build;
	// // return PushPayload.alertAll(msgContent);
	// }
	//
	
	/**
	 * 
	 * @comment: 构建推送对象：所有平台，推送目标是别名为 "alias"，通知内容为 ALERT
	 */
	// public static PushPayload buildPushObject_all_alias_alert(String alias , String msgContent)
	// {
	//
	// return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias))
	// .setNotification(Notification.newBuilder().setAlert(msgContent)
	// .addPlatformNotification(AndroidNotification.newBuilder().build())
	// .addPlatformNotification(
	// IosNotification.newBuilder().setSound("happy.caf").setBadge(0).build())
	// .build())
	// .build();
	// }
	
	
	/**
	 * 
	 * @comment: 平台是 Android，目标是 tag 为 "tag" 的设备，内容是 Android 通知 msgContent，并且标题为 TITLE。
	 */
	// public static PushPayload buildPushObject_android_tag_alertWithTitle(List<String> tag , String msgTitle ,
	// String msgContent)
	// {
	//
	// return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.tag(tag))
	// .setNotification(Notification.android(msgContent, msgTitle, null)).build();
	// }
	//
	//
	// public static PushPayload buildPushObject_android_and_ios(String tag , String msgTitle , String msgContent)
	// {
	//
	// return PushPayload.newBuilder().setPlatform(Platform.android_ios()).setAudience(Audience.tag(tag))
	// .setNotification(Notification.newBuilder().setAlert(msgContent)
	// .addPlatformNotification(AndroidNotification.newBuilder().setTitle(msgTitle).build())
	// .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).setBadge(0)
	// .setSound("happy").build())
	// .build())
	// .build();
	// }
	
	
	// 平台是 iOS，推送目标是 "tag1", "tag2" 的交集，推送内容同时包括通知与消息 - 通知信息是 ALERT，角标数字为 5，
	// 通知声音为 "happy"，并且附加字段 from = "JPush"；消息内容是 MSG_CONTENT。通知是 APNs 推送通道的，
	// 消息是 JPush 应用内消息通道的。APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(String registrationId ,
				String msgTitle , String msgContent)
	{
		
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.registrationId(registrationId))
					// setAudience(Audience.tag_and(tag1, tag2))
					.setNotification(Notification.newBuilder()
								.addPlatformNotification(IosNotification.newBuilder().setAlert(msgTitle).setBadge(5)
											.setSound("ring.wav").build())
								.build())
					.setMessage(Message.content(msgContent))
					.setOptions(Options.newBuilder().setApnsProduction(false).build()).build();
	}
	
	
	// 平台是 Andorid 与 iOS，推送目标是 （"tag1" 与 "tag2" 的并集）且（"alias1" 与 "alias2" 的并集），
	// 推送内容是 - 内容为 MSG_CONTENT 的消息，并且附加字段 from = JPush
	// public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras(String tag1 , String tag2 ,
	// String alias1 , String alias2 , String msgTitle , String msgContent)
	// {
	//
	// return PushPayload.newBuilder().setPlatform(Platform.android_ios())
	// .setAudience(Audience.newBuilder().addAudienceTarget(AudienceTarget.tag(tag1, tag2))
	// .addAudienceTarget(AudienceTarget.alias(alias1, alias2)).build())
	// .setMessage(Message.newBuilder().setMsgContent(msgContent).addExtra("from", "JPush").build())
	// .build();
	// }
	
	
	// 调用推送方法测试
	public static void main(String[] args)
	{
		
		JPushData jPushData = new JPushData();
		String content = "省份省份水电费";
		String title = "故事的故事";
		String id = "123";
		String registrationId = "1a1018970a8b412868c";// "141fe1da9e86bcc750c";
		// 推送标题名
		jPushData.setTitle(title);
		// 推送内容
		jPushData.setContent(content);
		// 推送需要传递的数据json，无数据可以不传
		Map<String , String> extras = new HashMap<String , String>();
		extras.put("orgId", "1");// 地址h5页面
		
		// 定义添加标签名字，极光服务器会根据注册时的接口关键此标签，
		List<String> tagColl = new ArrayList<String>();
		tagColl.add("buall");// 组织机构ID 北京
		tagColl.add("all");// 组织机构ID 北京
		tagColl.add("9999");// 组织机构ID 北京
		
		
		// 推送所有
		// sendAllPush(jPushData.getContent());// 全部推送
		sendAllPush(registrationId, jPushData.getTitle(), jPushData.getContent());
		// 个推，按照unid 集合推送
		// sendMemberPush(unid,jPushData.getContent());
		// 按照标签推送
		// sendAllTagPush(jPushData.getTags(),jPushData.getTitle(),jPushData.getContent());
		
	}
}