package com.dw.springbootsecurityweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Byron on 2022/6/22.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 需要有 Admin 角色才能访问
     * @return
     */
    @RequestMapping("/api")
    @ResponseBody
    public String admina(){
        return "这是admin的api";
    }





}
