package com.ljq.shardingjdbc.service;

import com.ljq.shardingjdbc.entity.UserInfo;
import com.ljq.shardingjdbc.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    public static long userId=1;
    public void insert(){
        for (int i = 0; i <=100; i++) {
            userInfoMapper.insert(UserInfo.builder()
                    .userId(userId).account("account"+i).password("password"+i).userName("name"+i).build());
            userId++;
        }
    }
}
