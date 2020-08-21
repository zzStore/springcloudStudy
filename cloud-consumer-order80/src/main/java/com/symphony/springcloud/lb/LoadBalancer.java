package com.symphony.springcloud.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * @Author zhengzhong
 * @Date 2020/7/25 11:16 AM
 */
public interface LoadBalancer {

  ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
