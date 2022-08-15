package com.chenyuhui.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 静态资源目录
 只要静态资源放在类路径下： called /static (or /public or /resources or /META-INF/resources
 访问 ： 当前项目根路径/ + 静态资源名

 原理： 静态映射/**。
 请求进来，先去找Controller看能不能处理。不能处理的所有请求又都交给静态资源处理器。静态资源也找不到则响应404页面

 静态资源访问前缀
 默认无前缀
 spring:
    mvc:
        static-path-pattern: /res/**
 当前项目 + static-path-pattern + 静态资源名 = 静态资源文件夹下找

 指定静态资源的访问文件夹
 spring:
    resources:
        static-locations: [classpath:/haha/]

 访问webjars
 自动映射 /webjars/**
 http://localhost:8080/webjars/jquery/3.5.1/jquery.js

**/

@RestController
public class StaticController {

    //@RequestMapping("/zhifubao.png")
    public String hello() {
        return "hello";
    }


}
