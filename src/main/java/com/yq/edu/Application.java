package com.yq.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    //入口函数
    public static void main(String[] args) {
        SpringApplication.run ( Application.class, args );
    }

}
