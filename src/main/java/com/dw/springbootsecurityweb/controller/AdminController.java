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
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
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
     * ????????? Admin ??????????????????
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
//        user1.setNote("?????????????????????????????????");
//        user1.setCreateTime(LocalDateTime.now());
//        user1.setLoginTime(user1.getCreateTime());
//        user1.setStatus(1);
//
//        DwUser user2 = new DwUser();
//        user2.setUsername("tom");
//        user2.setPassword(passwordEncoder.encode("123"));
//        user2.setEmail("tom@126.com");
//        user2.setNickname("small tom");
//        user2.setNote("????????????????????????");
//        user2.setCreateTime(LocalDateTime.now());
//        user2.setLoginTime(user2.getCreateTime());
//        user2.setStatus(1);
//
//        dwUserService.save(user1);
//        System.out.println("?????????????????????id:"+user1.getId());
//
//        List<DwUser> list = new ArrayList<>();
//        list.add(user2);
//        dwUserService.saveBatch(list,list.size());
//
//        //?????????
//        DwRole role1 = new DwRole();
//        role1.setName("ADMIN");
//        role1.setDescription("???????????????????????????");
//        role1.setUserCount(0);
//        role1.setCreateTime(LocalDateTime.now());
//        role1.setStatus(1);
//        role1.setSort(1);//????????????????????????
//
//        DwRole role2 = new DwRole();
//        role2.setName("USER");
//        role2.setDescription("????????????????????????");
//        role2.setUserCount(0);
//        role2.setCreateTime(LocalDateTime.now());
//        role2.setStatus(1);
//        role2.setSort(2);
//        dwRoleService.save(role1);
//        dwRoleService.save(role2);

        //?????????????????????dw_user_role???

//        ??????????????????key-value????????????????????????????????????????????????T????????????
//       List<Map<String,Object>> usermap = dwUserService.listMaps(new QueryWrapper<DwUser>().eq("status",1));

//        List<DwUser> userlist = dwUserService.list(new QueryWrapper<DwUser>().eq("status",1));
//
//        List<DwRole> rolelist = dwRoleService.list(new QueryWrapper<DwRole>().eq("status",1));

        //??????????????????

//        userlist.stream().forEach(user->{
//            Long userid = user.getId();
//            rolelist.stream().forEach(role->{
//                Long roleid = role.getId();
//
//                //??????dw_user_role??????????????????
//                DwUserRole userRole =  dwUserRoleService.getOne(new QueryWrapper<DwUserRole>().eq("user_id",userid).eq("role_id",roleid));
//
//                if(userRole != null){
//                    //????????????
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
//        user3.setNote("?????????????????????????????????");
//        user3.setCreateTime(LocalDateTime.now());
//        user3.setLoginTime(user3.getCreateTime());
//        user3.setStatus(1);
//
//        DwUser user4 = new DwUser();
//        user4.setUsername("boy");
//        user4.setPassword(passwordEncoder.encode("123"));
//        user4.setEmail("boy@126.com");
//        user4.setNickname("boy_user");
//        user4.setNote("????????????????????????");
//        user4.setCreateTime(LocalDateTime.now());
//        user4.setLoginTime(user4.getCreateTime());
//        user4.setStatus(1);
//
//        List<DwUser> list3 = new ArrayList<>();
//        list3.add(user3);
//        list3.add(user4);
//        dwUserService.saveBatch(list3,list3.size());





        return "??????admin???api";
    }


    /**
     * ????????? ROLE_ADMIN ??????????????????
     * @return
     */
    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){
        LOGGER.info("?????? info {0}???","?????????");
        return "??????admin????????????test1";
    }


}
