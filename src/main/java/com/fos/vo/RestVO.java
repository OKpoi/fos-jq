package com.fos.vo;

import lombok.Data;

@Data
public class RestVO<T> {
  private Integer code;
  private String msg;
  private T data;
}
