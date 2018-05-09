package com.test.first.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 数据源配置
 * 
 * @author leoyou
 */
@Component
public class JdbcConfig {

	@Bean
	@Primary
	public DataSource operMasterDataSource(@Value("${jdbc.oper.master.driverName}") String driverName,
			@Value("${jdbc.oper.master.driverUrl}") String driverUrl,
			@Value("${jdbc.oper.master.username}") String username,
			@Value("${jdbc.oper.master.password}") String password) throws Exception {
		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(driverUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public DataSource operQueryDataSource(@Value("${jdbc.oper.query.driverName}") String driverName,
			@Value("${jdbc.oper.query.driverUrl}") String driverUrl,
			@Value("${jdbc.oper.query.username}") String username,
			@Value("${jdbc.oper.query.password}") String password) throws Exception {
		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(driverUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
