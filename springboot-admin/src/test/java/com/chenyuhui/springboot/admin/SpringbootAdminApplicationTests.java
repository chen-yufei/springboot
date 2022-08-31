package com.chenyuhui.springboot.admin;

import com.chenyuhui.springboot.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class SpringbootAdminApplicationTests {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        Long count = jdbcTemplate.queryForObject("select count(*) from t_cyh_user",Long.class);
        log.info("记录数为:{}",count);

        int num = userService.getTotalUser();
        log.info("记录数为:{}",num);

    }




}
