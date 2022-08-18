package com.chenyuhui.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 请求处理-常用参数注解使用
 注解：
 @PathVariable 路径变量
 @RequestHeader 获取请求头
 @RequestParam 获取请求参数（指问号后的参数，url?a=1&b=2）
 @CookieValue 获取Cookie值
 @RequestAttribute 获取request域属性
 @RequestBody 获取请求体[POST]
 @MatrixVariable 矩阵变量
 @ModelAttribute

**/
@RestController
public class ParameterTestController {

    //car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam(value = "age",required = false) Integer age,
                                     @RequestParam(value = "inters",required = false) List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue(value = "_ga",required = false) String _ga,
                                     @CookieValue(value = "_ga",required = false) Cookie cookie){

        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("_ga",_ga);
        //System.out.println(cookie.getName()+"===>"+cookie.getValue());
        return map;
    }


    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();

        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    // /boss/1;age=20/2;age=10

    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();

        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;

    }

}
