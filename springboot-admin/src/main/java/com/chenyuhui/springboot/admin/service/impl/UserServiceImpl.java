package com.chenyuhui.springboot.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenyuhui.springboot.admin.bean.User;
import com.chenyuhui.springboot.admin.mapper.UserMapper;
import com.chenyuhui.springboot.admin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int getTotalUser() {
        return userMapper.getTotalUser();
    }
}
