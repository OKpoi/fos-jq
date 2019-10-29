package com.fos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RestResultEnums {
  // 请求成功
  SUCCESS(200, "success"),
  // 请求失败
  FAIL(400, "fail"),
  ;

  private Integer code;
  private String msg;
}
