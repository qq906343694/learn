package com.springboot.schedule.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
 * 定时任务执行 需要加注解@Scheduled ,fixedRate表示上一次任务开始执行的时间
 */
@Component
public class ScheduleService {
	private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5)
	public void reportCurrentTime1() {
		log.info("The time is now 1{}", dateFormat.format(new Date()));
	}

	@Scheduled(fixedRate = 50)
	public void reportCurrentTime2() {
		log.info("The time is now 2{}", dateFormat.format(new Date()));
	}

	@Scheduled(fixedRate = 50)
	public void reportCurrentTime3() {
		log.info("The time is now 3{}", dateFormat.format(new Date()));
	}
}
