package com.dw.springbootsecurityweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Byron on 2022/6/22.
 */
@Controller
@RequestMapping("/login")
public class LoginController {


    @RequestMapping(value = "/go_login",method = RequestMethod.POST)
    public void go_login(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("登录用户："+username+","+password);
    }
    @RequestMapping("/ok")
    public String ok(){
        return "ok";
    }

}
