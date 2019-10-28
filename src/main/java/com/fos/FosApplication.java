package com.fos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.fos")
@SpringBootApplication
public class FosApplication {

    public static void main(String[] args) {
        SpringApplication.run(FosApplication.class, args);
    }

}
