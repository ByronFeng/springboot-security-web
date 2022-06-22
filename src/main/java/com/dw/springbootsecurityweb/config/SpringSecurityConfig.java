package com.dw.springbootsecurityweb.config;

import com.dw.springbootsecurityweb.component.DWUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 使用 spring security 5.7.x 进行安全配置
 * 先前版本使用继承 WebSecurityConfigurerAdapter
 * SecurityFilterChain  配置 HttpSecurity
 * WebSecurityCustomizer 配置 WebSecurity
 * See Also:
 * Created by Byron on 2022/6/21.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {


    private DWUserDetailsService userDetailsService;


    @Autowired
    public void setUserDetailsService(DWUserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }
//    {
////        AccessDecisionVoter
//        FilterSecurityInterceptor
//    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

         httpSecurity.authorizeHttpRequests(authorize -> {
            //不需要权限验证的配置
            authorize.antMatchers("/dwUser/**").permitAll()
                    .antMatchers("/static/**").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers(HttpMethod.OPTIONS).permitAll()//允许跨域请求的OPTIONS请求
                    .anyRequest().authenticated();//其他请求都需要权限，当启动网站时跳转到登录页面
        });

         httpSecurity.userDetailsService(userDetailsService);


         httpSecurity.formLogin(
                 config->{
                     config.loginPage("/mylogin.html")
                             .loginProcessingUrl("/login/go_login")
                             .successForwardUrl("/login/ok")
                             .permitAll();
                 }
         );

         httpSecurity.csrf().disable();


        return httpSecurity.build();
    }

    @Bean
    WebSecurityCustomizer ignoringCustomizer(){
        return (web)->{
            //不推荐这种写法，使用httpSecurity antMatchers("/static/**").permitAll()
//            web.ignoring().antMatchers("/static/**");
        };
    }



}
