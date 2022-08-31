package com.chenyuhui.springboot.admin.service.impl;


import com.chenyuhui.springboot.admin.mapper.UserMapper;
import com.chenyuhui.springboot.admin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;

    @Override
    public int getTotalUser() {
        return userMapper.getTotalUser();
    }
}
