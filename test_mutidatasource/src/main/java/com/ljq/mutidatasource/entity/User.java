package com.ljq.mutidatasource.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class User {
    int id;
    String name;
}
