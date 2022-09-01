package com.chenyuhui.springboot.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenyuhui.springboot.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    int getTotalUser();

}
