package com.symphony.springcloud;

import cn.hutool.db.sql.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhengzhong
 * @Date 2020/7/25 5:10 PM
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderFeignMain80.class,args);
  }
}
