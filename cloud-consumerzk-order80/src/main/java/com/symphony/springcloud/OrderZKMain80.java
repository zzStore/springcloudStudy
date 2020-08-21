package com.symphony.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/7/15 7:52 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderZKMain80.class,args);
  }
}
