package com.symphony.springcloud.controller;

import com.symphony.springcloud.entities.CommonResult;
import com.symphony.springcloud.service.PaymentFeignService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/7/25 5:28 PM
 */
@RestController
public class PaymentFeignController {

  @Resource
  private PaymentFeignService paymentFeignService;


  @GetMapping(value = "/consumer/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable("id") Long id){
    return paymentFeignService.getPaymentById(id);
  }

  //测试服务超时控制
  @GetMapping(value = "/consumer/payment/feign/timeout")
  public String paymentFeignTimeout(){
    //OpenFeign-Ribbon，客户端一般默认等待1秒钟
    return paymentFeignService.paymentFeignTimeout();
  }
}
