package com.chenyuhui.springboot.controller;

import com.chenyuhui.springboot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**

 * 1、浏览器发请求直接返回 xml    [application/xml]        jacksonXmlConverter
 * 2、如果是ajax请求 返回 json   [application/json]      jacksonJsonConverter
 * 3、如果硅谷app发请求，返回自定义协议数据  [appliaction/x-guigu]   xxxxConverter
 *          属性值1;属性值2;
 *
 * 步骤：
 * 1、添加自定义的MessageConverter进系统底层
 * 2、系统底层就会统计出所有MessageConverter能操作哪些类型
 * 3、客户端内容协商 [guigu--->guigu]
**/

@Controller
public class ResponseTestController {

    /*
    * http://localhost:8080/test/person?format=json
        或
      http://localhost:8080/test/person?format=xml
    * */

    @ResponseBody  //利用返回值处理器里面的消息转换器进行处理
    @GetMapping(value = "/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }

}

