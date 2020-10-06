package com.ljq.shardingjdbc.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class User {
    int id;
    String name;
}
