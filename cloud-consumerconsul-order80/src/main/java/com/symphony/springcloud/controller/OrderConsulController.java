package com.symphony.springcloud.controller;

import java.util.UUID;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhengzhong
 * @Date 2020/7/18 10:27 PM
 */
@RestController
@Slf4j
public class OrderConsulController {

  public static final String INVOKE_URL = "http://consul-provider-payment";

  @Resource
  private RestTemplate restTemplate;

  @GetMapping(value = "/consumer/payment/consul")
  public String paymentConsul(){
    String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul",String.class);
    return result;
  }
}
