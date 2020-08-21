package com.symphony.springcloud.controller;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhengzhong
 * @Date 2020/7/15 7:55 PM
 */
@RestController
@Slf4j
public class OrderZKController {

  public static final String INVOKE_URL = "http://cloud-provider-payment";

  @Resource
  private RestTemplate restTemplate;

  @GetMapping(value = "/consumer/payment/zk")
  public String paymentZK(){
    String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk",String.class);
    return result;
  }
}
