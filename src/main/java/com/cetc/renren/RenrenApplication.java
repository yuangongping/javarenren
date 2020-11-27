package com.cetc.renren;

import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cetc.renren.mapper")
public class RenrenApplication {
    public static void main(String[] args) {
        SpringApplication.run(RenrenApplication.class, args);
    }

}
