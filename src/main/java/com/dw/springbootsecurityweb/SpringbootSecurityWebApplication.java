package com.dw.springbootsecurityweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dw.springbootsecurityweb.mapper")
public class SpringbootSecurityWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityWebApplication.class, args);
    }

}
