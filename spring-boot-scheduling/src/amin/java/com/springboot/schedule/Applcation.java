package com.springboot.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时任务必要的注解
public class Applcation {

	public static void main(String[] args) {
		SpringApplication.run(Applcation.class, args);
	}
}
