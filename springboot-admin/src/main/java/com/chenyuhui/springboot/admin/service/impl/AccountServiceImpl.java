package com.chenyuhui.springboot.admin.service.impl;

import com.chenyuhui.springboot.admin.bean.Account;
import com.chenyuhui.springboot.admin.mapper.AccountMapper;
import com.chenyuhui.springboot.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctByid(Long id){
        return accountMapper.getAcct(id);
    }
}
