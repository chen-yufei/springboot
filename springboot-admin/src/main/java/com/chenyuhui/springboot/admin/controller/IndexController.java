package com.chenyuhui.springboot.admin.controller;

import com.chenyuhui.springboot.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {




    /*
    * 前往登录页
    * */
    @GetMapping(value = {"/","/login"})
    public String loginPage() {
        return "login";
    }

    /*
    * 账号登录
    * */
    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        if("admin".equals(user.getUserName()) && "1998".equals(user.getPassword())) {
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号或密码错误，请重新登陆");
            //返回登陆页面
            return "login";
        }
    }

    /*
    * 前往主界面
    * */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser == null) {
            model.addAttribute("msg","请重新登录");
            return "login";
        }
        return "main";
    }




}
