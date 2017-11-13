package com.btjf.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan("com.btjf")
@ImportResource(locations = {"consumer.xml"})
public class Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
	@Override
	protected WebApplicationContext createRootApplicationContext(ServletContext servletContext) {
		WebApplicationContext applicationContext = super.createRootApplicationContext(servletContext);
		//SpringBeanUtil.setApplicationContext(applicationContext);
		return applicationContext;
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		//SpringBeanUtil.setApplicationContext(applicationContext);
	}
}
