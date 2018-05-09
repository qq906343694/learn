
package com.test.first.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web登录配置
 * 
 * @author leoyou
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	
	public WebSecurityConfig ()
	{
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		
		http.authorizeRequests().anyRequest().permitAll();// 默认所有请求均不需登录态
		
		// 允许使用iframe
		http.headers().frameOptions().sameOrigin();
		
		// 开放接口不需要CSRF保护
		http.csrf().disable();
		
	}
	
}