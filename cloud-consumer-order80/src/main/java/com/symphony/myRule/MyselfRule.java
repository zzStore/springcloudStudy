package com.symphony.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhengzhong
 * @Date 2020/7/25 11:01 AM
 */
@Configuration
public class MyselfRule {

  @Bean
  public IRule myRule(){
    return new RandomRule();//定义为随机
  }
}
