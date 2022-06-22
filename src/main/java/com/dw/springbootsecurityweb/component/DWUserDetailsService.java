package com.dw.springbootsecurityweb.component;

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

/**
 * 自定义实现 UserDetailsService
 *
 * Created by Byron on 2022/6/22.
 */
@Component
public class DWUserDetailsService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * 从库中查询用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       return quickLoadUserDetails(username);
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
