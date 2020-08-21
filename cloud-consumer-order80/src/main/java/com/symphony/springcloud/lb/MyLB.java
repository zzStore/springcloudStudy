package com.symphony.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * @Author zhengzhong
 * @Date 2020/7/25 11:17 AM
 */
@Component
public class MyLB implements LoadBalancer {

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  public final int getAndIncrement(){
    int current;
    int next;
    do{
      current = this.atomicInteger.get();
      next = current >= Integer.MAX_VALUE ? 0 : current + 1;
      //当原子atomicInteger.get()值等于current，则原子值设为next，并返回true，否则返回false，不改变原子atomicInteger的值
    }while (!this.atomicInteger.compareAndSet(current,next));
    System.out.println("***第几次访问，次数：" + next);
    return next;
  }

  @Override
  public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
    int index = getAndIncrement() % serviceInstances.size();
    return serviceInstances.get(index);
  }
}
