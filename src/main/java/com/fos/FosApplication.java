package com.fos;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan("com.fos.dao")
public class FosApplication {

    private static String name;

    @Value("${Env.name}")
    public void setName(String data) {
        name = data;
    }

//    @Value("${Env.fileUpLoadPath}")
//    public void setPathList(List<String> data) {
//        PathList = data;
//    }

    public static void main(String[] args) {
        SpringApplication.run(FosApplication.class, args);
        log.info("======================================");
        log.info("   环境:  " + name);
        log.info("   系统:  " + System.getProperty("os.name"));
        log.info("======================================");
    }
}
