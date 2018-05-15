package com.xph.redis.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/*
 * 多线程定时任务设置
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar arg0) {
		// TODO Auto-generated method stub
		arg0.setScheduler(Executors.newScheduledThreadPool(10));
	}

}
