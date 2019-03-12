package com.oracle.hrb.zhzw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oracle.hrb.zhzw.dao")
public class ZhzwApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhzwApplication.class, args);
    }

}