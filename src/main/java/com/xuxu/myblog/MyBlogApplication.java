package com.xuxu.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;

/**
 * 博客启动器
 *
 * @author MonsterXu
 * @date 2020-07-17 11:31:52
 */

//mapper扫描
@MapperScan("com.xuxu.my_blog.dao")
@SpringBootApplication
public class MyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBlogApplication.class, args);
    }

}
