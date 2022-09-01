package com.chenyuhui.springboot.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenyuhui.springboot.admin.bean.User;


import java.util.List;


public interface UserService extends IService<User> {

    public int getTotalUser();

}
