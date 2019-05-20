package com.bysj.ssm_forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bysj.dao")
@SpringBootApplication(scanBasePackages = "com.bysj")
public class SsmForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmForumApplication.class, args);
    }

}
