package com.xph.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xph.redis.entity.User;
import com.xph.redis.util.TemlateUtil;

@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	private TemlateUtil template;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setId(1);
		user.setName("象鼻蚌");
		template.SetObject("1", user);
		// 原本opsForValue()是只能操作字符串的.现在就可以操作对象了

		System.out.println(template.GetObject("1"));
	}
}
