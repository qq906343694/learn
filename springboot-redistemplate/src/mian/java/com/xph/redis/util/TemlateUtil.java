package com.xph.redis.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TemlateUtil {

	@Resource
	private RedisTemplate<Object, Object> template;

	public void SetList(String key, List list) {
		template.opsForList().leftPush(key, list);
	}

	public List GetList(String key) {
		return (List) template.opsForList().leftPop(key);
	}

	public void SetSet(String key, Set values) {
		template.opsForSet().add(key, values);
	}

	public Set GetSet(String key) {
		return template.opsForSet().members(key);
	}

	public void SetMap(String key, Map values) {
		template.opsForHash().putAll(key, values);
	}

	public Map GetMap(String key) {
		return template.opsForHash().entries(key);
	}

	public void SetObject(String key, Object value) {
		template.opsForValue().set(key, value);
	}

	public Object GetObject(String key) {
		return template.opsForValue().get(key);
	}
}
