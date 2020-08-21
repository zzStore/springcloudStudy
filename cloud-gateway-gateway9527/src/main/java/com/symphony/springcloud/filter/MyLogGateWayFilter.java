package com.symphony.springcloud.filter;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author zhengzhong
 * @Date 2020/8/21 11:09 AM
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter,Ordered {


  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("come in filter" + new Date());
    String uname = exchange.getRequest().getQueryParams().getFirst("uname");
    //只有当参数有uname且不为空时才可通过过滤器
    if(uname == null){
      log.info("非法用户");
      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
      return exchange.getResponse().setComplete();
    }
    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
