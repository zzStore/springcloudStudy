package com.symphony.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author zhengzhong
 * @Date 2020/8/9 11:29 AM
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

  public static void main(String[] args) {
    SpringApplication.run(HystrixDashboardMain9001.class,args);
  }
}
