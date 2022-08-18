package com.chenyuhui.springboot.controller;


import org.springframework.web.bind.annotation.*;

/**
 @xxxMapping;
 @GetMapping @PostMapping @PutMapping @DeleteMapping
 Rest风格支持（使用HTTP请求方式动词来表示对资源的操作）

**/

@RestController
public class RestFulController {

    @GetMapping("/user")
    //@RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @PostMapping("/user")
    //@RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }

    @PutMapping("/user")
    //@RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @DeleteMapping("/user")
    //@RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }

}
