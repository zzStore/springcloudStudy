package com.symphony.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhengzhong
 * @Date 2020/8/5 3:28 PM
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

  @GetMapping("/payment/hystrix/ok/{id}")
  public String paymentInfo_ok(@PathVariable("id") Integer id);

  @GetMapping("/payment/hystrix/timeout/{id}")
  public String paymentInfo_timeOut(@PathVariable("id") Integer id);
}
