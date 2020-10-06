package com.ljq.shardingjdbc.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class UserInfo {
    private Long userId;
    private String userName;
    private String account;
    private String password;


}
