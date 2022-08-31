package com.chenyuhui.springboot.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int getTotalUser();

}
