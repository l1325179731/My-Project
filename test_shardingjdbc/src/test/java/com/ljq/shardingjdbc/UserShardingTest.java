package com.ljq.shardingjdbc;

import com.ljq.shardingjdbc.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = "com.ljq.shardingjdbc.mapper")
public class UserShardingTest {
    @Autowired
    UserService userService;
    @Test
    public void insert(){
        userService.insert();
    }
}
