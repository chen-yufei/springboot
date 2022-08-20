package com.chenyuhui.springboot.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 默认情况下，Spring Boot提供/error处理所有错误的映射
 自定义错误页
 error/404.html   error/5xx.html；有精确的错误状态码页面就匹配精确，没有就找 4xx.html；如果都没有就触发白页

 ● @ControllerAdvice+@ExceptionHandler处理全局异常；底层是 ExceptionHandlerExceptionResolver 支持的

 ● @ResponseStatus+自定义异常 ；底层是 ResponseStatusExceptionResolver ，
    把responsestatus注解的信息底层调用 response.sendError(statusCode, resolvedReason)；tomcat发送的/error
**/

@Controller
public class ErrorController {

    @GetMapping("/error01")
    public String error01() {
        int i = 1 / 0;
        return "main";
    }

    @GetMapping("/error02")
    public String error02() {
        String s = null;
        System.out.println(s.length());
        return "main";
    }


}
