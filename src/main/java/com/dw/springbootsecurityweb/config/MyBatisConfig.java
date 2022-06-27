package com.dw.springbootsecurityweb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Byron on 2022/6/23.
 */
@Configuration
@MapperScan("com.dw.springbootsecurityweb.mapper")
public class MyBatisConfig {


}
