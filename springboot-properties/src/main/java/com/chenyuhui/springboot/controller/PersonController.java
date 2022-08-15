package com.chenyuhui.springboot.controller;


import com.chenyuhui.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person(){

        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }
}
