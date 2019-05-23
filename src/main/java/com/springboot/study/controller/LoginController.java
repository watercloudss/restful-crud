package com.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(String username, String password, Map<String,String> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123123".equals(password)){
            session.setAttribute("loginSession",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误");
            return "index";
        }
    }

}
