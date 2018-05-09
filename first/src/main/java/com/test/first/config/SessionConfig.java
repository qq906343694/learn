
package com.test.first.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.util.StringUtils;

import redis.embedded.RedisExecProvider;
import redis.embedded.util.OS;
import redis.embedded.util.OSDetector;

/**
 * 分布式Session配置
 * 
 * @author
 */
@EnableRedisHttpSession
public class SessionConfig
{
	
	@Lazy
	@Bean
	public JedisConnectionFactory connectionFactory(@Value("${spring.redis.enable}") boolean enable ,
				@Value("${spring.redis.master}") String master , @Value("${spring.redis.host}") String hostName ,
				@Value("${spring.redis.port}") Integer port , @Value("${spring.redis.pass}") String password)
	{
		
		if (enable)
		{
			RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master(master);
			sentinelConfig.sentinel(hostName, port);
			
			JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfig);
			jedisConnectionFactory.setPassword(password);
			return jedisConnectionFactory;
		}
		else
		{
			startRedisServer();
			return new JedisConnectionFactory();
		}
	}
	
	
	private void startRedisServer()
	{
		
		try
		{
			if (OSDetector.getOS() == OS.WINDOWS)
			{
				Process proc = null;
				BufferedReader br = null;
				try
				{
					proc = Runtime.getRuntime().exec("tasklist.exe");
					br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
					String line;
					String fileName = RedisExecProvider.defaultProvider().get().getName();
					while ((line = br.readLine() ) != null)
					{
						if (line.startsWith(fileName))
						{
							return;
						}
					}
				}
				finally
				{
					if (br != null)
					{
						br.close();
					}
					if (proc != null)
					{
						proc.destroy();
					}
				}
			}
			new LocalRedisServer().start();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	@Bean
	public CookieSerializer cookieSerializer(@Value("${session.cookie.name}") String cookieName ,
				@Value("${session.domain.name}") String domainName)
	{
		
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		if (! StringUtils.hasText(cookieName))
		{
			cookieName = "jsessionid";
		}
		serializer.setCookieName(cookieName);
		// 设置CookiePath为/ ， 这样 nginx 代理去掉 ContextPath 后才能正常获得 Cookie
		serializer.setCookiePath("/");
		// 设置Cookie可以在二级域名内共享
		if (StringUtils.hasText(domainName))
		{
			serializer.setDomainName(domainName);
		}
		else
		{
			serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
		}
		return serializer;
	}
	
}
