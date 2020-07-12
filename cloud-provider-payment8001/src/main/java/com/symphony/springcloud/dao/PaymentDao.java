package com.symphony.springcloud.dao;

import com.symphony.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhengzhong
 * @Date 2020/7/2 5:09 PM
 */
@Mapper
public interface PaymentDao {

  public int create(Payment payment);

  public Payment getPaymentById(@Param("id") Long id);
}
