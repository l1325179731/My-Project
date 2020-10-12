package com.ljq.mutidatasource.mapper;

import com.ljq.mutidatasource.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

     User getById(int id);
}
