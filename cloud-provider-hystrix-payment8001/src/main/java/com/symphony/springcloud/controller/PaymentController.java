package com.symphony.springcloud.controller;

import com.symphony.springcloud.service.PaymentService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/8/5 2:32 PM
 */
@RestController
@Slf4j
public class PaymentController {

  @Resource
  private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  /**
   * 正常访问，肯定ok
   * @param id
   * @return
   */
  @RequestMapping("/payment/hystrix/ok/{id}")
  public String paymentInfo_ok(@PathVariable("id") Integer id){
    String result = paymentService.paymentInfo_ok(id);
    log.info("****result:" + result);
    return result;
  }

  /**
   * 延时访问
   * @param id
   * @return
   */
  @RequestMapping("/payment/hystrix/timeout/{id}")
  public String paymentInfo_timeOut(@PathVariable Integer id){
    String result = paymentService.paymentInfo_timeOut(id);
    log.info("****result:" + result);
    return result;
  }

  //服务熔断
  @GetMapping("/payment/circuit/{id}")
  public String paymentCircuitBreaker(@PathVariable("id") Integer id){
    String result = paymentService.paymentCircuitBreaker(id);
    log.info("********result:" + result);
    return result;
  }
}
