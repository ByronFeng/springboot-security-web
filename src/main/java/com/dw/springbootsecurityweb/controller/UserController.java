package com.dw.springbootsecurityweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Byron on 2022/6/22.
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * 需要有 User 角色才能访问
     * @return
     */
    @RequestMapping("/api")
    @ResponseBody
    public String user(){

        log.info("这是使用了 @Slf4j 代替在类中添加代码的方式");
        return "这是user的api";
    }

}
