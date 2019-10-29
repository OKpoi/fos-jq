package com.fos.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestVO<T> {
  private Integer code;
  private String msg;
  private T data;
}
