package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhengzhong
 * @Date 2020/7/4 8:17 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain80 {

  public static void main(String[] args){
    SpringApplication.run(OrderMain80.class,args);
  }

}
