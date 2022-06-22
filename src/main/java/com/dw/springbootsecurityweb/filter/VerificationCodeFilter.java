package com.dw.springbootsecurityweb.filter;


import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在 spring security 添加验证码验证，需要在用户名和密码之前先验证验证码
 * 用户名密码验证过滤器：UsernamePasswordAuthenticationFilter
 * Created by Byron on 2022/6/22.
 */
public class VerificationCodeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {






    }
}
