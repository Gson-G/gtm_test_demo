package com.btjf.test.demo.config.mybaits;

import com.icar.finance.event.EventManagementConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by 10731 on 2017/9/20.
 */
@Configuration
//@EnableTransactionManagement
@MapperScan(value = "com.btjf.business.**.mapper")
public class MybatisConfig {


    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public EventManagementConfig eventManagementConfig() {
        EventManagementConfig eventManagementConfig = new EventManagementConfig();
        eventManagementConfig.setApplicationName("bt-business");
        //eventManagementConfig.setRocketMQNameSvrAddress("192.168.100.222:9876");
        return eventManagementConfig;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/btjf/business/**/mapper/*.xml"));

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }

    /*@Bean
    public MapperScannerConfigurer mapperScannerConfigurer(SqlSessionFactory sqlSessionFactory) {
        MapperScannerConfigurer mapperScannerConfigurer =  mapperScannerConfigurer(sqlSessionFactory);
        mapperScannerConfigurer.setBasePackage("com.btjf.business.**.mapper");

        return mapperScannerConfigurer;
    }*/
}
