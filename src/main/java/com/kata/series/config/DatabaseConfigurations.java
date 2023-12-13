package com.kata.series.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfigurations {

	/*
	 * @Bean("SQL") DataSource myDatasource() throws SQLException {
	 * 
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setUrl("jdbc:h2:mem:testdb1");
	 * dataSource.setDriverClassName("org.h2.Driver"); dataSource.setUsername("sa");
	 * dataSource.setUsername("password"); return dataSource; }
	 */
}
