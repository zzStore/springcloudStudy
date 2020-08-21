package com.symphony.springcloud.controller;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/7/18 9:55 PM
 */
@RestController
@Slf4j
public class PaymentController {
  @Value("${server.port}")
  private String serverPort;

  @RequestMapping("/payment/consul")
  public String paymentConsul(){
    return "springcloud with consul:"+serverPort+"\t"+ UUID.randomUUID().toString();
  }
}
