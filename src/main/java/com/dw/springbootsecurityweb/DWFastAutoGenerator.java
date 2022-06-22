package com.dw.springbootsecurityweb;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.thymeleaf.standard.processor.StandardIfTagProcessor;

import javax.crypto.interfaces.PBEKey;
import java.util.Collections;

/**
 * Created by Byron on 2022/6/21.
 */
public class DWFastAutoGenerator {

    public static final String output_dir = "src//main//java";
//    public static final String output_dir = "D://tmp//";
    public static final String program_package = "com.dw.springbootsecurityweb";
    public static final String mysql_url = "jdbc:mysql://127.0.0.1:3306/dw";
    public static final String mysql_username = "root";
    public static final String mysql_pw = "tiger";


    public static void main(String[] args) {

//        FastAutoGenerator fag =   FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/boot", "root", "tiger");

        FastAutoGenerator fag = FastAutoGenerator.create(mysql_url, mysql_username, mysql_pw);

        fag.globalConfig(builder -> {
            builder.author("Byron") // 设置作者
//                    .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                    .dateType(DateType.TIME_PACK)//jdk8下time新特性
                    .commentDate("yyyy-MM-dd")
                    .outputDir(output_dir); // 指定输出目录
        });

        fag.templateConfig(builder -> {
            builder.disable(TemplateType.ENTITY)//不使用模板创建
                    .entity("/templates/entity.java")//对应的模板
                    .service("/templates/service.java")
                    .serviceImpl("/templates/serviceImpl.java")
                    .mapper("/templates/mapper.java")
                    .xml("/templates/mapper.xml")
                    .controller("/templates/controller.java");
        });


        fag.packageConfig(builder -> {
            builder.parent(program_package) // 设置父包名
                    //.moduleName("system") // 设置父包模块名
                    .controller("controller")
                    .serviceImpl("service.impl")
                    .service("service")
                    .mapper("mapper")
                    .xml("mapper.xml")
                    .entity("entity")//po的包
                    .pathInfo(Collections.singletonMap(OutputFile.xml, "src//main//resources//com//dw//springbootsecurityweb//mapper")); // 设置mapperXml生成路径
        });

//        fag.strategyConfig(builder -> {
//            builder.addInclude("user") // 设置需要生成的表名
//            //.addTablePrefix("t_", "c_")// 设置过滤表前缀
//            ;
//        });

        fag.templateEngine(new FreemarkerTemplateEngine()); // 使用Freemarker引擎模板，默认的是Velocity引擎模板

        fag.execute();


    }
}
