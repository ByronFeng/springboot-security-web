package com.dw.springbootsecurityweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Byron on 2022/6/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 需要有 User 角色才能访问
     * @return
     */
    @RequestMapping("/api")
    @ResponseBody
    public String user(){
        return "这是user的api";
    }

}
