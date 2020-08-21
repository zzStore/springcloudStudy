package com.symphony.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.symphony.springcloud.service.PaymentHystrixService;
import javax.annotation.Resource;
import lombok.Builder.Default;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhengzhong
 * @Date 2020/8/5 3:32 PM
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

  @Resource
  private PaymentHystrixService paymentHystrixService;

  @GetMapping("/consumer/payment/hystrix/ok/{id}")
  public String paymentInfo_ok(@PathVariable("id") Integer id){
    String result = paymentHystrixService.paymentInfo_ok(id);
    return result;
  }

  @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//  @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//  })
  @HystrixCommand
  public String paymentInfo_timeOut(@PathVariable("id") Integer id){
//    int age = 10/0;
    String result = paymentHystrixService.paymentInfo_timeOut(id);
    return result;
  }

  public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
    return "我是消费者80，对方支付系统繁忙，请10秒钟后再试或者自己运行出错检查自己，o(╥﹏╥)o";
  }

  //全局服务降级方法，如果没有特殊降级方法配置，调用此方法
  public String payment_Global_FallbackMethod(){
    return "Global异常处理信息，请稍后再试，_(¦3」∠)_";
  }
}
