package com.symphony.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhengzhong
 * @Date 2020/7/2 5:02 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
//Json封装体，类加泛型T，返回对象也为T
public class CommonResult<T> {

  private Integer code;

  private String message;

  //向前端返回对象
  private T data;

  //新建2个参数的构造方法，以防止没有实体类返回时报错
  public CommonResult(Integer code,String message){
    this(code,message,null);
  }

}
