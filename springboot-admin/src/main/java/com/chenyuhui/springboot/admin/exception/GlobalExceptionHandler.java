package com.chenyuhui.springboot.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.jws.WebParam;

/**
 * 处理整个web controller的异常
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NullPointerException.class})  //处理异常
    public String handleArithException(Exception e, Model model) {
        log.error("异常是：{}",e);
        model.addAttribute("message",e.getMessage());
        return "/error/error"; //视图地址
    }



}
