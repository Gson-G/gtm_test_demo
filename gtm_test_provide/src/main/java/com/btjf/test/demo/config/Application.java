package com.btjf.test.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Created by 10731 on 2017/9/20.
 */
@SpringBootApplication
@ComponentScan({"com.btjf","com.icar"})
@ImportResource(locations = {"provide.xml","applicationContext-disconf.xml","applicationContext-redis.xml"})
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Override
    protected WebApplicationContext createRootApplicationContext(ServletContext servletContext) {
        WebApplicationContext applicationContext = super.createRootApplicationContext(servletContext);
        return applicationContext;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        ProxyTransactionManagementConfiguration proxyTransactionManagementConfiguration = applicationContext.getBean(ProxyTransactionManagementConfiguration.class);
        System.out.print(proxyTransactionManagementConfiguration.getClass());
    }
}
