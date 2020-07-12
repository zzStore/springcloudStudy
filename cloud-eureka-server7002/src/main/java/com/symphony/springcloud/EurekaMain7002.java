package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author zhengzhong
 * @Date 2020/7/11 3:43 PM
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {

  public static void main(String[] args) {
    SpringApplication.run(EurekaMain7002.class,args);
  }
}
