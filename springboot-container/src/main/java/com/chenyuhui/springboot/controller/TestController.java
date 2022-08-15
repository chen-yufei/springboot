package com.chenyuhui.springboot.controller;

import com.chenyuhui.springboot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
@Slf4j的注解相当于private  final Logger logger = LoggerFactory.getLogger(当前类名.class);
**/
@Slf4j
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){
        log.info("请求进来了....");
        return "Hello, Spring Boot 2!"+"你好："+name;
    }

    @Autowired
    private Car car;


    @RequestMapping("/car")
    public Car car(){
        return car;
    }

}
