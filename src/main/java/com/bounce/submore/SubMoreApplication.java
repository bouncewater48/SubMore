package com.bounce.submore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bounce.submore.user.repository")
public class SubMoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubMoreApplication.class, args);
    }

}
