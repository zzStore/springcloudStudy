package com.symphony.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author zhengzhong
 * @Date 2020/8/8 6:57 PM
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

  @Override
  public String paymentInfo_ok(Integer id) {
    return "--------PaymentFallbackService.paymentInfo_ok,o(╥﹏╥)o";
  }

  @Override
  public String paymentInfo_timeOut(Integer id) {
    return "--------PaymentFallbackService.paymentInfo_timeOut,o(╥﹏╥)o";
  }
}
