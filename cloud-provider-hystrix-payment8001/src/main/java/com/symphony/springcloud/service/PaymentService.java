package com.symphony.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhengzhong
 * @Date 2020/8/5 2:21 PM
 */
@Service
public class PaymentService {

  /**
   * 正常访问，肯定ok
   * @param id
   * @return
   */
  public String paymentInfo_ok(Integer id){
    return "线程池：" + Thread.currentThread().getName() + "paymentInfo_ok,id:" + id + "\t" + "O(∩_∩)O哈哈~";
  }

  /**
   * 延时访问
   * @param id
   * @return
   */
  @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
  })//方法执行失败或超时，调用备用兜底的方法paymentInfo_TimeOutHandler
  public String paymentInfo_timeOut(Integer id){


    int timeNumber = 5;
    try {
      TimeUnit.SECONDS.sleep(timeNumber);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "线程池：" + Thread.currentThread().getName() + "paymentInfo_timeOut,id:" + id + "\t" + "(#^.^#) 耗时（秒）：" + timeNumber;

//    int age = 10/0;
//    return "线程池：" + Thread.currentThread().getName() + "paymentInfo_timeOut,id:" + id;

  }

  /**
   * 方法执行失败或超时，调用备用兜底的方法
   * @param id
   * @return
   */
  public String paymentInfo_TimeOutHandler(Integer id){
    return "线程池：" + Thread.currentThread().getName() + "8001系统繁忙或者运行报错,id:" + id + "\t" + "o(╥﹏╥)o";
  }

  //服务熔断
  @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
      @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
      @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
  })
  public String paymentCircuitBreaker(@PathVariable("id") Integer id){
    if(id < 0){
      throw new RuntimeException("******id不能为负数");
    }
//    int age = 10/0;

    //等价于UUID.randomUUID().toString()，生成不带-的字符串，唯一识别码
    String serialNumber = IdUtil.simpleUUID();
    return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
  }

  public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
    return "id 不能为负数，请稍后再试，o(╥﹏╥)o  id:" + id;
  }
}
