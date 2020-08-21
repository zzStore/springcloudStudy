package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhengzhong
 * @Date 2020/7/13 8:30 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8004.class,args);
  }
}
