package com.symphony.springcloud.config;

import feign.Logger;
import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhengzhong
 * @Date 2020/7/25 6:38 PM
 */
@Configuration
public class FeignConfig {

  @Bean
  Logger.Level feignLoggerLevel(){
    return Level.FULL;
  }
}
