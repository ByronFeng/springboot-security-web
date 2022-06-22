package com.dw.springbootsecurityweb.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

/**
 *
 * 自定义
 *
 * Created by Byron on 2022/6/22.
 */
@Component
public class DWUserDetailsService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails rel = null;
        UserDetails admin = User.withUsername("cat").password(new BCryptPasswordEncoder().encode("123")).roles("ADMIN").build();
        UserDetails user = User.withUsername("tom").password(passwordEncoder.encode("123")).roles("USER").build();
        if(username.equals("cat")){
                rel = admin;
        }else if(username.equals("tom")){
            rel=user;
        }
        return rel;
    }
}
