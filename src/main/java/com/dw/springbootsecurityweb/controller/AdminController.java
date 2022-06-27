package com.dw.springbootsecurityweb.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.dw.springbootsecurityweb.entity.DwRole;
import com.dw.springbootsecurityweb.entity.DwUser;
import com.dw.springbootsecurityweb.entity.DwUserRole;
import com.dw.springbootsecurityweb.service.impl.DwRoleServiceImpl;
import com.dw.springbootsecurityweb.service.impl.DwUserRoleServiceImpl;
import com.dw.springbootsecurityweb.service.impl.DwUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.tree.VoidDescriptor;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Byron on 2022/6/22.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private DwUserServiceImpl dwUserService;
    private DwUserRoleServiceImpl dwUserRoleService;
    private DwRoleServiceImpl dwRoleService;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setDwUserService(DwUserServiceImpl dwUserService){
        this.dwUserService = dwUserService;
    }
    @Autowired
    public void setDwUserRoleService(DwUserRoleServiceImpl dwUserRoleService){
        this.dwUserRoleService = dwUserRoleService;
    }
    @Autowired
    public void setDwRoleService(DwRoleServiceImpl dwRoleService){
        this.dwRoleService = dwRoleService;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
    /**
     * 需要有 Admin 角色才能访问
     * @return
     */
    @RequestMapping("/api")
    @ResponseBody
    public String admina(){

//        DwUser user1 = new DwUser();
//        user1.setUsername("cat");
//        user1.setPassword(passwordEncoder.encode("123"));
//        user1.setEmail("cat@126.com");
//        user1.setNickname("bigcat");
//        user1.setNote("这是一个管理员角色用户");
//        user1.setCreateTime(LocalDateTime.now());
//        user1.setLoginTime(user1.getCreateTime());
//        user1.setStatus(1);
//
//        DwUser user2 = new DwUser();
//        user2.setUsername("tom");
//        user2.setPassword(passwordEncoder.encode("123"));
//        user2.setEmail("tom@126.com");
//        user2.setNickname("small tom");
//        user2.setNote("这是一个用户角色");
//        user2.setCreateTime(LocalDateTime.now());
//        user2.setLoginTime(user2.getCreateTime());
//        user2.setStatus(1);
//
//        dwUserService.save(user1);
//        System.out.println("能否得到用户的id:"+user1.getId());
//
//        List<DwUser> list = new ArrayList<>();
//        list.add(user2);
//        dwUserService.saveBatch(list,list.size());
//
//        //角色表
//        DwRole role1 = new DwRole();
//        role1.setName("ADMIN");
//        role1.setDescription("这是一个管理员角色");
//        role1.setUserCount(0);
//        role1.setCreateTime(LocalDateTime.now());
//        role1.setStatus(1);
//        role1.setSort(1);//数字小的排在前面
//
//        DwRole role2 = new DwRole();
//        role2.setName("USER");
//        role2.setDescription("这是一个用户角色");
//        role2.setUserCount(0);
//        role2.setCreateTime(LocalDateTime.now());
//        role2.setStatus(1);
//        role2.setSort(2);
//        dwRoleService.save(role1);
//        dwRoleService.save(role2);

        //上面连个数据进dw_user_role表

//        查出来的数据key-value，一般给前端可以使用，后端还是用T的好操作
//       List<Map<String,Object>> usermap = dwUserService.listMaps(new QueryWrapper<DwUser>().eq("status",1));

//        List<DwUser> userlist = dwUserService.list(new QueryWrapper<DwUser>().eq("status",1));
//
//        List<DwRole> rolelist = dwRoleService.list(new QueryWrapper<DwRole>().eq("status",1));

        //设置两者关表

//        userlist.stream().forEach(user->{
//            Long userid = user.getId();
//            rolelist.stream().forEach(role->{
//                Long roleid = role.getId();
//
//                //判断dw_user_role是否已经存在
//                DwUserRole userRole =  dwUserRoleService.getOne(new QueryWrapper<DwUserRole>().eq("user_id",userid).eq("role_id",roleid));
//
//                if(userRole != null){
//                    //存在不管
//                }else {
//                    userRole = new DwUserRole();
//                    userRole.setUserId(userid);
//                    userRole.setRoleId(roleid);
//                    dwUserRoleService.save(userRole);
//                }
//
//            });
//        });


//        DwUser user3 = new DwUser();
//        user3.setUsername("manager");
//        user3.setPassword(passwordEncoder.encode("123"));
//        user3.setEmail("manager@126.com");
//        user3.setNickname("manager_user");
//        user3.setNote("这是一个管理员角色用户");
//        user3.setCreateTime(LocalDateTime.now());
//        user3.setLoginTime(user3.getCreateTime());
//        user3.setStatus(1);
//
//        DwUser user4 = new DwUser();
//        user4.setUsername("boy");
//        user4.setPassword(passwordEncoder.encode("123"));
//        user4.setEmail("boy@126.com");
//        user4.setNickname("boy_user");
//        user4.setNote("这是一个用户角色");
//        user4.setCreateTime(LocalDateTime.now());
//        user4.setLoginTime(user4.getCreateTime());
//        user4.setStatus(1);
//
//        List<DwUser> list3 = new ArrayList<>();
//        list3.add(user3);
//        list3.add(user4);
//        dwUserService.saveBatch(list3,list3.size());





        return "这是admin的api";
    }


    /**
     * 需要有 ROLE_ADMIN 角色才能访问
     * @return
     */
    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){
        return "这是admin权限下的test1";
    }


}
