package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhengzhong
 * @Date 2020/8/19 5:06 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {

  public static void main(String[] args) {
    SpringApplication.run(GateWayMain9527.class,args);
  }
}
