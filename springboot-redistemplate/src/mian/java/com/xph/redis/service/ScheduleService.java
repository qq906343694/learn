package com.xph.redis.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xph.redis.entity.User;
import com.xph.redis.util.TemlateUtil;

/*
 * 定时任务执行 需要加注解@Scheduled ,fixedRate表示上一次任务开始执行的时间
 */
@Component
public class ScheduleService {
	private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Resource
	private RedisTemplate<Object, Object> template;

	@Autowired
	private TemlateUtil temlateUtil;

	@Scheduled(fixedRate = 500)
	public void reportCurrentTime1() {
		log.info("The time is now 1{}", dateFormat.format(new Date()));
		User user = new User();
		user.setId(1);
		user.setName("象鼻蚌");
		template.opsForValue().set(user.getId() + "", user);
		// 原本opsForValue()是只能操作字符串的.现在就可以操作对象了
		User result = (User) template.opsForValue().get(user.getId() + "");
		System.out.println(result.toString());
		User user1 = new User();
		user1.setId(2);
		user1.setName("象鼻蚌");
		template.opsForValue().set(2 + "", user1);
		template.boundListOps("1");
		Set<User> set = new HashSet<User>();
		set.add(user1);
		set.add(user);
		template.opsForSet().add("3", set);
		System.out.println(template.opsForSet().randomMember("3"));
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user1);
		template.opsForList().leftPushAll("4", list);
		List list1 = (List) template.opsForList().leftPop("4");
		System.out.println("list:" + list1);
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "大黄鱼");
		map.put("2", "文蛤");
		template.opsForHash().putAll("map", map);
		Map map1 = new HashMap();
		map1 = template.opsForHash().entries("map");
		System.out.println(map1.get("1"));

	}

	@Scheduled(fixedRate = 500)
	public void reportCurrentTime2() {
		log.info("The time is now 2 {}", dateFormat.format(new Date()));
		User user = new User();
		user.setId(1);
		user.setName("真的象鼻蚌");
		temlateUtil.SetObject("1", user);
		System.out.println(temlateUtil.GetObject("1"));
	}

}
