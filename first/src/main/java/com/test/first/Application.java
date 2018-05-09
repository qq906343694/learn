
package com.test.first;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.github.tobato.fastdfs.FdfsClientConfig;


@Import(FdfsClientConfig.class)
@ComponentScan
@EnableScheduling
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer
{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		
		return application.sources(Application.class);
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		SpringApplication.run(Application.class, args);
	}
}
