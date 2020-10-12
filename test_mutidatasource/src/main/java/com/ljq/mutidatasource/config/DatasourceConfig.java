package com.ljq.mutidatasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DatasourceConfig {
    @Bean
    @ConfigurationProperties(prefix ="ljq.datasource.db1")
    public DataSource dataSource1(){
        return new HikariDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix ="ljq.datasource.db2")
    public DataSource dataSource2(){
        return new HikariDataSource();
    }
    @Primary
    @Bean
    public MutiDatasource routeDatasource(){
        MutiDatasource mutiDatasource=new MutiDatasource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("db1",dataSource1());
        targetDataSources.put("db2",dataSource2());
        mutiDatasource.setTargetDataSources(targetDataSources);
        mutiDatasource.setDefaultTargetDataSource(dataSource1());
        return mutiDatasource;
    }
}
