
package com.test.first.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushUtil
{
	
	private final static Logger logger = LoggerFactory.getLogger(PushUtil.class);
	
	private final static String appKey = "092acbbc32d81a2eab77f2af";
	
	private final static String masterSecret = "b80cc83ab4aabf75653b261c";
	
	private final static ClientConfig clientConfig = ClientConfig.getInstance();
	
	private final static JPushClient jpushClient = new JPushClient(masterSecret , appKey , null , clientConfig);
	
	
	private static PushPayload buildPushObject_ios(String content , String[] tags , String[] alias ,
				Boolean apnsProduction , JsonObject extraMsgJsonObject)
	{
		
		PushPayload.Builder builder = PushPayload.newBuilder();
		
		builder.setPlatform(Platform.ios());
		
		if (tags != null)
			builder.setAudience(Audience.tag(tags));
		if (alias != null)
			builder.setAudience(Audience.alias(alias));
		
		builder.setNotification(Notification.newBuilder().setAlert(content)
					.addPlatformNotification(
								IosNotification.newBuilder().addExtra("msg", extraMsgJsonObject).incrBadge(1).build())
					.build());
		builder.setOptions(Options.newBuilder().setApnsProduction(apnsProduction).build());
		return builder.build();
	}
	
	
	public static Boolean pushNotification(String content , List<String> tags , List<String> alias ,
				Boolean apnsProduction , JsonObject extraMsgJsonObject)
	{
		
		String[] tagsArr = null;
		String[] aliasArr = null;
		if (tags != null && ! tags.isEmpty())
		{
			tagsArr = new String[tags.size()];
			tags.toArray(tagsArr);
		}
		if (alias != null && ! alias.isEmpty())
		{
			aliasArr = new String[alias.size()];
			alias.toArray(aliasArr);
		}
		PushPayload pushPayload = buildPushObject_ios(content, tagsArr, aliasArr, apnsProduction, extraMsgJsonObject);
		try
		{
			PushResult result = jpushClient.sendPush(pushPayload);
			logger.info(result.toString());
			return result.isResultOK();
		}
		catch (APIConnectionException e)
		{
			e.printStackTrace();
		}
		catch (APIRequestException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static void main(String[] args)
	{
		
		List<String> list = new ArrayList<>();
		list.add("150");
		// list.add( "10001540" );
		String content = "充值成功，请查看余额";
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("type", 30);
		PushUtil.pushNotification(content, null, list, false, null);
	}
	
}
