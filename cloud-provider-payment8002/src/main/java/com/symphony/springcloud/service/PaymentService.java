package com.symphony.springcloud.service;

import com.symphony.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhengzhong
 * @Date 2020/7/2 5:25 PM
 */
public interface PaymentService {

  public int create(Payment payment);

  public Payment getPaymentById(@Param("id") Long id);
}
