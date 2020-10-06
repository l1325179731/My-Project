package com.ljq.test_springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class TestSpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestSpringbootApplication.class, args);
        DruidDataSource dataSource1 = context.getBean("dataSource1", DruidDataSource.class);
        System.out.println(dataSource1.getUsername());
        System.out.println(dataSource1.getDriverClassName());
        // System.out.println(context.getBean("dataSource2",DataSource.class));
    }

}
