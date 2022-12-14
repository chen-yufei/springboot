package com.chenyuhui.springboot.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.chenyuhui.springboot.admin.servlet")
@MapperScan("com.chenyuhui.springboot.admin.mapper")
public class SpringbootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminApplication.class, args);
    }

}
