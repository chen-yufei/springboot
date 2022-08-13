package com.chenyuhui.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 ● 默认的包结构
 ○ 主程序所在包及其下面的所有子包里面的组件都会被默认扫描进来
 ○ 无需以前的包扫描配置
 ○ 想要改变扫描路径，@SpringBootApplication(scanBasePackages="com.chenyuhui")
     ■ 或者@ComponentScan 指定扫描路径

 @SpringBootApplication
 等同于
 @SpringBootConfiguration
 @EnableAutoConfiguration
 @ComponentScan("com.chenyuhui.springboot")

 ● 各种配置拥有默认值
 ○ 默认配置最终都是映射到某个类上，如：MultipartProperties
 ○ 配置文件的值最终会绑定每个类上，这个类会在容器中创建对象
 ● 按需加载所有自动配置项
 ○ 非常多的starter
 ○ 引入了哪些场景这个场景的自动配置才会开启
 ○ SpringBoot所有的自动配置功能都在 spring-boot-autoconfigure 包里面
**/


@SpringBootApplication  //@SpringBootApplication：这是一个SpringBoot应用
public class MainApplication {


    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }

}
