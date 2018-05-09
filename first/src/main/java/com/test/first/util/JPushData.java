
package com.test.first.util;

import java.util.List;

public class JPushData
{
	
	private String title; // 推送标题
	
	private String content; // 推荐内容
	
	private List<String> tags; // 推送分类标签
	
	private List<String> alias; // 推送别名
	
	
	public String getTitle()
	{
		
		return title;
	}
	
	
	public void setTitle(String title)
	{
		
		this.title = title;
	}
	
	
	public String getContent()
	{
		
		return content;
	}
	
	
	public void setContent(String content)
	{
		
		this.content = content;
	}
	
	
	public List<String> getTags()
	{
		
		return tags;
	}
	
	
	public void setTags(List<String> tags)
	{
		
		this.tags = tags;
	}
	
	
	public List<String> getAlias()
	{
		
		return alias;
	}
	
	
	public void setAlias(List<String> alias)
	{
		
		this.alias = alias;
	}
	
}

// 把要推送的东西组装好以后，就调用PushManage中的sendAllPush进行全体消息推送了。


/**
 * 
 * @comment: 极光推送管理
 */

