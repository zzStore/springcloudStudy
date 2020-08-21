package com.symphony.springcloud.service;

import com.symphony.springcloud.entities.CommonResult;
import com.symphony.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhengzhong
 * @Date 2020/7/25 5:17 PM
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

  @GetMapping(value = "/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable("id") Long id);

  //测试服务超时控制
  @GetMapping(value = "/payment/feign/timeout")
  public String paymentFeignTimeout();
}
