package com.symphony.springcloud.service;

import com.symphony.springcloud.dao.PaymentDao;
import com.symphony.springcloud.entities.Payment;
import javax.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Author zhengzhong
 * @Date 2020/7/2 5:26 PM
 */
@Service("paymentServiceImpl_1")
public class PaymentServiceImpl implements PaymentService{

  @Resource
  private PaymentDao paymentDao;

  public int create(Payment payment){
    return paymentDao.create(payment);
  }

  public Payment getPaymentById(Long id){
    return paymentDao.getPaymentById(id);
  }
}
