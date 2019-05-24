package com.springboot.study.controller;

import com.springboot.study.exception.MessageException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author:  lly
 * Date:    2019/5/24 14:14
 * Description:
 */
@Controller
public class ResponseMessageController {
    @GetMapping("/hello/{a}")
    @ResponseBody
    public String hello(@PathVariable int a){
        if(a==1){
            throw new MessageException("哈哈哈！老弟！报错了吧!");
        }else{
            return "hello world!";
        }
    }
}
