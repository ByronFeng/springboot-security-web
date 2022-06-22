package com.dw.springbootsecurityweb.controller;

import com.dw.springbootsecurityweb.entity.DwUser;
import com.dw.springbootsecurityweb.service.IDwUserService;
import com.dw.springbootsecurityweb.service.impl.DwUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Byron
 * @since 2022-06-21
 */
@Controller
@RequestMapping("/dwUser")
public class DwUserController {
    @Autowired
    private DwUserServiceImpl dwUserService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public String getUser(){
       DwUser user =  dwUserService.getById(1);
       return user.toString();
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public int add(){
        DwUser user = new DwUser();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setEmail("hell@qq.com");
        user.setNickname("ZS");
        user.setNote("这是备忘录");
        user.setCreateTime(LocalDateTime.now());
        user.setLoginTime(LocalDateTime.now());
        user.setStatus(1);
        boolean b =  dwUserService.save(user);
        return b? 1:-1;
    }

}
