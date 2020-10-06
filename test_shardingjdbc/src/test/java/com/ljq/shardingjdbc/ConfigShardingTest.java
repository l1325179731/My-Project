package com.ljq.shardingjdbc;

import com.ljq.shardingjdbc.service.ConfigService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = "com.ljq.shardingjdbc.mapper")

public class ConfigShardingTest {
    @Autowired
    ConfigService configService;

    @Test
    public void insert(){
        configService.insert();
    }

    @Test
    public void updata(){
        configService.update(2);
    }
}
