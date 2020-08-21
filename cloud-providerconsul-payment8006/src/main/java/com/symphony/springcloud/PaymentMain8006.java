package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhengzhong
 * @Date 2020/7/18 9:54 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8006.class,args);
  }
}
