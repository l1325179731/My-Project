package com.ljq.mutidatasource;

import com.ljq.mutidatasource.config.DataSourceContext;
import com.ljq.mutidatasource.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestMutidatasourceApplicationTests {



    @Test
    void contextLoads() {

    }
    @Autowired
    UserMapper userMapper;
    @Test
    void select(){
        DataSourceContext.setDataSource("db2");
        System.out.println(userMapper.getById(1));
    }

}
