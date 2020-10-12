package com.ljq.mutidatasource;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableConfigurationProperties
@MapperScan(basePackages = "com.ljq.mutidatasource.mapper")
public class TestMutidatasourceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestMutidatasourceApplication.class, args);
        HikariDataSource datasource1 = (HikariDataSource) context.getBean("dataSource1");
        System.out.println(context.getBean("userMapper"));
    }

}
