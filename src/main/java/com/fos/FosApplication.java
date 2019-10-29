package com.fos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/** lomofu */
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.fos")
public class FosApplication {

  private static String name;

  @Value("${Env.name}")
  public void setName(String data) {
    name = data;
  }

  public static void main(String[] args) {
    SpringApplication.run(FosApplication.class, args);
    log.info("======================================");
    log.info("   环境:  " + name);
    log.info("======================================");
  }
}
