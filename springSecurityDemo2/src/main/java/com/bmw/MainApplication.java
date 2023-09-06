package com.bmw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/12
 */
@SpringBootApplication
@MapperScan("com.bmw.mapper")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }
}
