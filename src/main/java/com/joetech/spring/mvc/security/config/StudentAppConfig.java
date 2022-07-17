package com.joetech.spring.mvc.security.config;

import java.nio.charset.StandardCharsets;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/* This config is no longer used -> Check  StudentDAOImpl, that is where the implementation moved to */
@Configuration
public class StudentAppConfig  implements WebMvcConfigurer  {
	   private static final Logger LOGGER   = LoggerFactory
	            .getLogger(StudentAppConfig.class);
	@Bean
	public JdbcTemplate jdbcTemplate() {
		LOGGER.info("We are inside StudentAppConfig jdbcTemplate");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		//set the db info to thr datasource object
		LOGGER.info("We are inside StudentAppConfig dataSource collecting DB credientials");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/seleniumexpress?allowPublicKeyRetrieval=true&useSSL=false");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
		
		
	}


	 

}
