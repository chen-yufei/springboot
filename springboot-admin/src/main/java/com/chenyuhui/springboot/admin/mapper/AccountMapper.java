package com.chenyuhui.springboot.admin.mapper;

import com.chenyuhui.springboot.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}
