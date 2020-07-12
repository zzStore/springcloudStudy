package com.symphony.springcloud.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhengzhong
 * @Date 2020/7/2 4:59 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{

  private Integer id;

  private String serial;
}
