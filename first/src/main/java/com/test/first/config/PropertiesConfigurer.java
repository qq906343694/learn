
package com.test.first.config;

import org.springframework.context.annotation.Configuration;

/**
 * 配置文件顺序配置
 * 
 * @author leoyou
 */
@Configuration
public class PropertiesConfigurer
{
	
	// private static final String TOMCAT_BASE_PROPERTY_NAME = "catalina.base";
	//
	// @Bean
	// public PropertyPlaceholderConfigurer properties() {
	// final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
	//
	// final List<Resource> resList = new ArrayList<Resource>();
	// resList.add(new ClassPathResource("application.properties"));
	//
	// String base = System.getProperty(TOMCAT_BASE_PROPERTY_NAME);
	// if (StringUtils.hasText(base)) {
	// resList.add(new FileSystemResource(base + "/conf/application.properties"));
	// }
	//
	// ppc.setLocations(resList.toArray(new Resource[resList.size()]));
	//
	// return ppc;
	// }
}
