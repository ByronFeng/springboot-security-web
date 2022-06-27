package com.dw.springbootsecurityweb.component;

import com.dw.springbootsecurityweb.domain.DwUserDetails;
import com.dw.springbootsecurityweb.domain.SysUser;
import com.dw.springbootsecurityweb.service.impl.DwUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 自定义实现 UserDetailsService
 * <p>
 * Created by Byron on 2022/6/22.
 */
@Component
public class DWUserDetailsService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    private DwUserServiceImpl dwUserService;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setDwUserService(DwUserServiceImpl dwUserService) {
        this.dwUserService = dwUserService;
    }


    /**
     * 从库中查询用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //从内存中获取
//        return quickLoadUserDetails(username);
        //从数据库中获取
        return loadUserFromDB(username);

    }

    /**
     * 从数据库获取用户数据
     *
     * @param username
     * @return
     */
    private UserDetails loadUserFromDB(String username) {
        //自定义的UserDetails对象
        DwUserDetails userDetails = new DwUserDetails();

        SysUser sysUser = dwUserService.loadUserByUsername(username);
        System.out.println("【根据用户"+username+"查询的用户角色信息：】");
        System.out.println(sysUser);
        if (sysUser != null) {
            userDetails.setUsername(sysUser.getUsername());
            userDetails.setPassword(sysUser.getPassword());
            userDetails.setAuthorityList(sysUser.getSysRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList()));
        }
        System.out.println("【用户角色】");
        System.out.println(userDetails);
        return userDetails;
    }

    /**
     * 快速模拟从数据库中查询数据
     *
     * @return
     */
    private UserDetails quickLoadUserDetails(String username) {

        List<UserDetails> list = new ArrayList<>();
        list.add(User.withUsername("cat").password(passwordEncoder.encode("123")).roles("ADMIN").build());
        list.add(User.withUsername("tom").password(passwordEncoder.encode("123")).roles("USER").build());
        Optional<UserDetails> op = list.stream().filter(u -> u.getUsername().equals(username)).findFirst();
        return op.get();
    }


}
