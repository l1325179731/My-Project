package com.ljq.shardingjdbc.config;


import com.zaxxer.hikari.HikariDataSource;
import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import io.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 分片数据源配置，返回 ShardingDataSource
 */
@Configuration
@MapperScan(basePackages = "com.gupaoedu.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
    @Bean
    @Primary
    public DataSource shardingDataSource() throws SQLException {
        ShardingRuleConfiguration src = new ShardingRuleConfiguration();
        // 默认的分库策略
        src.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new DBShardAlgo()));
        // 默认的分表策略
        src.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new TblPreShardAlgo(),new TblRangeShardAlgo()));
        // 为user_info表设置分库分表策略、算法
        // src.getTableRuleConfigs().add(getUserTableRuleConfiguration());
        // 数据源名和数据源的映射表

        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), src,new HashMap<>(),new Properties());
    }

    // 配置数据源
    private Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("ds0", createDataSource("jdbc:mysql://localhost:3306/ds0?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("ds1", createDataSource("jdbc:mysql://localhost:3306/ds1?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        return result;
    }

    // 根据数据源地址创建 DataSource
    private DataSource createDataSource(final String dataSourceName) {
        HikariDataSource result = new HikariDataSource();
        result.setDriverClassName("com.mysql.jdbc.Driver");
        result.setJdbcUrl(dataSourceName);
        result.setUsername("root");
        result.setPassword("123456");
        return result;
    }

    // 事务管理器
    @Bean
    public DataSourceTransactionManager transactitonManager(DataSource shardingDataSource) {
        return new DataSourceTransactionManager(shardingDataSource);
    }

    // 为user_info表设置分库分表策略、算法
    public TableRuleConfiguration getUserTableRuleConfiguration() {
        TableRuleConfiguration userTableRuleConfig=new TableRuleConfiguration();
        userTableRuleConfig.setLogicTable("user_info");
        userTableRuleConfig.setActualDataNodes("ds0.user_info, ds1.user_info");
        userTableRuleConfig.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new DBShardAlgo()));
        userTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id",new TblPreShardAlgo(), new TblRangeShardAlgo()));
        return userTableRuleConfig;
    }

}
