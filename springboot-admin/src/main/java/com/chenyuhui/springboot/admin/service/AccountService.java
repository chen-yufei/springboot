package com.chenyuhui.springboot.admin.service;

import com.chenyuhui.springboot.admin.bean.Account;
import com.chenyuhui.springboot.admin.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AccountService {

    Account getAcctByid(Long id);
}
